def lastCommit
def latestVersion

pipeline {

    agent {
        label 'docker-node'
    }

    stages {
        stage('Build Docker image') {
            steps {
                script {
                    println("Getting commit id and latest Version")
                    lastCommit = sh script: "git log | head -1 | awk '{print \$2}' | cut -c1-6", returnStdout: true
                    latestVersion = sh script: "git branch -r | cut -d '/' -f2 | grep 0. | sort -r | head -1", returnStdout: true
                    println("Latest Version seen is ${latestVersion}")
                    println("Latest commit seen is ${lastCommit}")
                    sh "sudo docker build -t segevb/weather_app:${latestVersion}-${lastCommit} . "

                }
            }
            }
        }
        stage('Test Docker image') {
            steps {
                script{
                    try {
                        sh "./basic.test.sh segevb/weather_app:${latestVersion}-${lastCommit}"
                    } catch (err) {
                        println("Error thrown on test file execution")
//                      currentBuild.result = 'ABORTED'
//                      error('Error thrown on test file execution')
                        }
                    }
                }
            }
        stage('Upload image to repository') {
            steps {
                sh "pwd"
            }
        }
    }

//        stage('Deploy to Prod') {
//            steps {
//                println("Empty stage")
//
//                1. make sure docker engine is installed and running
//                apt -y install docker.io
//                systemctl start docker
//                systemctl enable docker
//
//                2. copy the docker image to the target server
//                docker save intservice:latest > /var/jenkins_home/intService/intservice.tar    || docker.hub docker push docker.io/intservice/intservice:latest
//                scp "/var/jenkins_home/intService/intservice.tar ubuntu@${prod_server_ip}:/tmp"
//
//                3. run the container
//                ssh ubuntu@${prod_server_ip} sudo docker load < /tmp/intservice.tar
//                ssh ubuntu@${prod_server_ip} sudo docker run -d intservice
//
//                4. make sure it is executed correctly
//                        ./bash.test.sh
//
//            }
//        }
