#!groovy
// Check ub1 properties
properties([disableConcurrentBuilds()])

pipeline {
    agent { 
        label 'master'
        }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }
    stages {
        stage("First step") {
            steps {
                sh 'ssh test@ecsb003009ed.epam.com \'hostname\''
            }
        }
        stage("Second step") {
            steps {
                sh 'ssh test@ecsb003009ed.epam.com \'uptime\''
            }
        }
    }
}