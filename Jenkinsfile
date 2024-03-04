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
				-Dsonar.binaries=./build/classes \
				-Dsonar.junit.reportPaths=./build/test-results/test \
				-Dsonar.coverage.jacoco.xmlReportPaths=./build/reports/jacoco/test/html/index.html \
				-Dsonar.projectKey=employeemgmt23"
			}
		}
	}
  }
  triggers {
    pollSCM('')
  }
}