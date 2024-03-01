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
				   bat "${tool("sonarqube")}/bin/sonar-scanner \
				   -Dsonar.projectKey=employeemanagement1 \
				   -Dsonar.sources=. \
				   -Dsonar.css.node=. \
				   -Dsonar.host.url=http://localhost:9000 \
				   -Dsonar.login=1d52371b8f0c9bb0698a9b650975113d51560a56"
					   }
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