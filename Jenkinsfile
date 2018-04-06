pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                ansiColor('xterm') {
                    sh "sbt ';clean ;compile ;doc'"
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}