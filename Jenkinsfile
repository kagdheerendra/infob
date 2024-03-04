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
			environment {
				scannerHome = tool 'sonarqubescanner'
			}
			steps {
				withSonarQubeEnv('sonarqubeserver') {
					bat "${scannerHome}/bin/sonar-scanner"
				}
				timeout(time: 10, unit: 'MINUTES') {
					waitForQualityGate abortPipeline: true
				}
			}
        }
    }
}