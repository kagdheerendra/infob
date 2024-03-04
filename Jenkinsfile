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
				bat "${scannerHome}/bin/sonar-scanner \
				-Dsonar.sources=src/main/ -Dsonar.tests=src/test/ -Dsonar.java.binaries=build/**/* -Dsonar.language=java \
				-Dsonar.projectKey=employeemgmt23"
			}
		}
	}
  }
  triggers {
    pollSCM('')
  }
}