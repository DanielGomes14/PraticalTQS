pipeline {
    agent any
    tools { 
            jdk 'JDK11'
            maven 'mvn36'
            }
    stages {
            steps {
                dir('/lab8/P2Euromillions'){
                    sh "$PWD"  
            }    
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
                sh "mvn clean install" 
                } 
            post {
                always {
                    junit '**/target/*-reports/TEST-*.xml'
                    } 
                } 
            } 
        }
    }
} 