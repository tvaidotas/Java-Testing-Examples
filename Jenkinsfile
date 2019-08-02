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
        stage('Build') {
            steps {
                sh 'echo "Hello world!"'
            }
        }
    }
}