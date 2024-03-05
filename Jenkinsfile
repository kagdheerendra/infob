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
				-Dsonar.sources=./dummygradle/ -Dsonar.java.binaries=. -Dsonar.language=java \
				-Dsonar.projectKey=dummygradlesonarproject"
			}
		}
	}
    stage("Quality Gate") {
		steps {
			timeout(time: 1, unit: 'MINUTES') {
				    def qg = waitForQualityGate()
					print "Finished waiting"
					if (qg.status != 'OK') {
						error "Pipeline aborted due to quality gate failure: ${qg.status}"
					}
			}
		}
    }	
  }
  triggers {
    pollSCM('')
  }
}