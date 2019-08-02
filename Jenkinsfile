pipeline {
    agent any
    tools {
            maven 'mvn'
            jdk 'jdk'
    }
    stages {
        stage('clean'){
            steps {
                sh 'mvn clean'
            }
        }
        stage('build') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('test'){
            steps {
                sh 'mvn test'
            }
        }
    }
}