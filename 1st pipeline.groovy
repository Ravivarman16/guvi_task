pipeline {
    agent { label 'test' }

    stages {
        stage('Git cloning') {
            steps {
                git branch: 'master',
                url: 'https://github.com/Ravivarman16/guvi_task.git'
            }
        }

        stage ('Building a dockerimage') {
            steps {
                sh 'docker rm -f $(docker ps -aq)'
                sh 'docker build -t ravivarman46/guviimage .'
                sh 'docker run -d --name container1 -p 8080:80 ravivarman46/guviimage'
                sh 'docker push ravivarman46/guviimage'
            }
        }
    }
}
