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
			withSonarQubeEnv() { // Will pick the global server connection you have configured
			  bat 'gradlew sonarqube'
			}
        }
        stage('Build') {
            steps {
			    bat 'gradle build'
            }
        }
    }
}