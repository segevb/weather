def userInput

pipeline {
    agent any

    stages {
        stage('Input') {
            userInput = input message: 'Please provide your input', ok: 'confirm', parameters: [choice(name: '', choices: ['option 1', 'option2'], description: '')]
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
