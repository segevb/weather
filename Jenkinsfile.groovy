def userInput

pipeline {
    agent any

    stages {
        stage('Build Docker image') {
            steps {
                script {
                    sh " docker build -t weather ."
                }
            }
        }
        stage('Upload image to repository') {
            steps {
                println("Input was " + userInput)
            }

        }
    }
}
