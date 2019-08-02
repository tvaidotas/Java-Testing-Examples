pipeline {
    agent any
    tools {
            MVN 'mvn'
            JDK 'jdk'
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