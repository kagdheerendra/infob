pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Go to the dir') {
            steps {
			    bat 'cd dummygradle'
            }
        }
        stage('SonarQube Analysis') { 
		   steps {
                bat 'gradle sonarqube'
		   }
        }
        stage('Build') {
            steps {
			    bat 'gradle build'
            }
        }
    }
}