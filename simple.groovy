#!/usr/bin/env groovy
// Check ub1 properties
properties([disableConcurrentBuilds()])

pipeline {
    agent { 
        label 'linux'
        }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }
    stages {
        stage('First stage') {
            steps {
                withCredentials([usernamePassword(
                        credentialsId: 'jenkins-pass',
                        passwordVariable: 'passwd',
                        usernameVariable: 'user')]) {
                    sh "pwd"
                    sh "hostname"
                    sh "echo $passwd"
                    sh "echo $user"
                }
            }
        }
        stage("Second stage") {
            steps {
                sh 'ls'
            }
        }
    }
}