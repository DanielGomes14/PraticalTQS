pipeline {
    agent any
    tools {
        jdk 'JDK11'
        maven 'Maven'
    }
    stages {
        stage('test java installation') {
            steps {
                sh 'java -version'
            }
        }
        stage('test maven installation') {
            steps {
                sh 'mvn -version'
            }
        }
        stage('Install') {
            steps {
                dir('./lab1/P2Euromillions'){
                    sh "mvn clean install"
                } 
            }
            post {
                always {
                    junit '*/target/-reports/TEST-*.xml'
                }
            }
        }
    } 
}
