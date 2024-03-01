pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
			    bat 'cd dummygradle'
                bat 'gradle build'
            }
        }
    }
}