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

    stage('SonarCloud') {
      environment {
        SCANNER_HOME = tool 'sonarqubescanner'
        SONAR_TOKEN = credentials('SonarQube Access Token')
        ORGANIZATION = "igorstojanovski-github"
        PROJECT_NAME = "igorstojanovski_jenkins-pipeline-as-code"
      }
      steps {
        withSonarQubeEnv(installationName: 'sonarqubeserver', credentialsId: 'SonarQube Access Token') {
            bat '''$SCANNER_HOME/bin/sonar-scanner -Dsonar.organization=$ORGANIZATION \
            -Dsonar.java.binaries=build/classes/java/ \
            -Dsonar.projectKey=$PROJECT_NAME \
            -Dsonar.sources=.'''
        }
      }
    }

    stage("Quality Gate") {
      steps {
        timeout(time: 1, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
      }
    }

  }
  triggers {
    pollSCM('')
  }
}