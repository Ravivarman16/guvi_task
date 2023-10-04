pipeline {
    agent { label 'prod'}

    stages {
        stage ('production by docker') {
            steps {
                sh 'docker rm -f $(docker ps -aq)'
                sh 'docker run -d --name container1 -p 8080:80 ravivarman46/guviimage'
            }
        }
    }
}
