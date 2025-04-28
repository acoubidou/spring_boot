pipeline {
    agent any
    environment {
        registry = "acoubidou/webspringboot"

        registryCredential = '2'
        dockerImage = ''
    }
    tools {
        maven 'maven'
        jdk 'JDK21'
    }
    stages {
        stage('Clean workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Git Checkout') {
            steps {
                script {
                    git branch: 'main',
                        credentialsId: '1',
                        url: 'https://github.com/acoubidou/spring_boot.git'
                }
            }
        }
        stage('Build Maven') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('acoubidou/webspringboot:latest', '-f Dockerfile .')
                }
            }
        }
        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        docker.image('acoubidou/webspringboot:latest').push()
                    }
                }
            }
        }
        stage('Deploy docker-compose') {
            steps {
                script {
                    bat 'docker-compose up -d --build --force-recreate --remove-orphans'
                }
            }
        }
    }
}