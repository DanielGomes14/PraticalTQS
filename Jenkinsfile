pipeline {
    agent any
    tools { 
            jdk 'JDK11'
            maven 'mvn36'
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
    }
} 