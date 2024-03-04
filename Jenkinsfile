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
		stage('Build') {
            steps {
			    bat 'gradle build'
            }
        }
        stage('SonarQube Analysis') { 
		    step  {
				withSonarQubeEnv() { // Will pick the global server connection you have configured
				  bat 'gradle sonarqube'
				}
			}
        }
    }
}