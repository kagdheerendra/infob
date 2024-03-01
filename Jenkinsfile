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
		stage('Code Quality Check via SonarQube') {
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