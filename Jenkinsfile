pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
			    sh 'cd dummygradle'
                sh 'gradle clean build -x test'
            }
        }
    }
}