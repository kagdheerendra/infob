pipeline {
  agent any
  stages {
	stage('Go to the dir') {
		steps {
			bat 'cd dummygradle'
		}
	}
    stage('Gradle Build') {
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
		}
	}
  }
  triggers {
    pollSCM('')
  }
}