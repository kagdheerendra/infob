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
				-Dsonar.sources=./dummygradle/src/main/ \
				-Dsonar.java.binaries=.build/target/classes/ \
				-Dsonar.projectKey=employeemgmt23"
			}
		}
	}
  }
  triggers {
    pollSCM('')
  }
}