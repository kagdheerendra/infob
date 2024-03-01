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
        stage('SonarQube Analysis') { 
		   steps {
			   script {
				   def scannerHome = tool 'sonarqube';
					   withSonarQubeEnv("sonarqube-container") {
					   sh "${tool("sonarqube")}/bin/sonar-scanner \
					   -Dsonar.projectKey=test-node-js \
					   -Dsonar.sources=. \
					   -Dsonar.css.node=. \
					   -Dsonar.host.url=http://your-ip-here:9000 \
					   -Dsonar.login=your-generated-token-from-sonarqube-container"
					}
			   }
		   }
        }
        stage('Build') {
            steps {
			    bat 'gradle build'
            }
        }
    }
}