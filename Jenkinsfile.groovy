pipeline {
    agent any

    stages {
        stage('Input') {
            input 'Please provide your input'
        }
        stage('Hello') {
            steps {
                dir ('coolNewDirectory') {
                    git branch: 'main', credentialsId: 'github_cred', url: 'https://github.com/segevb/weather.git'
                    echo 'Hello World'
                }
            }
        }
        stage('check working directory') {
            steps {
                sh "pwd"
            }

        }
    }
}
