pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "slave_maven"
    }

    stages {
        stage('SCM Checkout') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/LoksaiETA/Java-mvn-app2.git'
            }
	}
        stage('Maven Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
	}
}
}
