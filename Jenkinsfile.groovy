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
#        stage('Test Docker image') {
#            steps {
#                script {
#                    sh "sh ./basic.test.sh"
#                }
#            }
#        }
        stage('Upload image to repository') {
            steps {
                println("Input was " + userInput)
            }

        }
    }
}
