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
		   steps {
			   script {
				   def scannerHome = tool 'sonarqubescanner';
				   withSonarQubeEnv("sonarqubeserver") {
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
        }
    }
}