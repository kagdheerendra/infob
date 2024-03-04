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
        ORGANIZATION = "igorstojanovski-github"
        PROJECT_NAME = "igorstojanovski_jenkins-pipeline-as-code"
      }
      steps {
        withSonarQubeEnv('sonarqubeserver') {
		   bat "${tool("sonarqubescanner")}/bin/sonar-scanner \
		   -Dsonar.projectKey=employeemgmt \
		   -Dsonar.sources=. \
		   -Dsonar.css.node=. \
		   -Dsonar.analysis.mode= \
		   -Dsonar.host.url=http://localhost:9000 \
		   -Dsonar.login=1d52371b8f0c9bb0698a9b650975113d51560a56"
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