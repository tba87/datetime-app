pipeline {
    agent any

    tools {
        jdk 'jdk17' // Use the name you gave in Global Tool Configuration
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/tba87/datetime-app.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }

        stage('Build and Run Docker Container') {
            steps {
               script {
                        // Stop and remove existing container if running
                        sh 'docker stop datetime-app || true'
                        sh 'docker rm datetime-app || true'
            
                        // Remove existing image if exists
                        sh 'docker rmi datetime-image || true'
            
                        // Build new image
                        sh 'docker build -t datetime-image .'
            
                        // Run new container with port mapping 9090:8080
                        sh 'docker run -d -p 9090:8080 --name datetime-app datetime-image'
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'Application is running at http://<your-server-ip>:9090'
        }
    }
}
