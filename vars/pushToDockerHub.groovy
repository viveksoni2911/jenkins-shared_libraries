def call(){
    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh """
                        echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
                        docker tag java-notes-app:latest \$DOCKER_USER/java-notes-app:latest
                        echo "docker image tag addded: \$DOCKER_USER/java-notes-app:latest"
                        docker push \$DOCKER_USER/java-notes-app:latest
                        """ 
    }
}
