pipeline {
 agent any
 environment {
  dockerHome = tool 'myDocker'
  mavenHome = tool 'myMaven'
  PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
 }

 stages {
  stage('Checkout') {
   steps {
    echo "Build"
    echo "PATH - $PATH"
    echo "BUILD_NUMBER - $env.BUILD_NUMBER"
    echo "BUILD_ID - $env.BUILD_ID"
    echo "JOB_NAME - $env.JOB_NAME"
    echo "BUILD_TAG - $env.BUILD_TAG"
    echo "BUILD_URL - $env.BUILD_URL"
   }
  }

  stage('Check Docker') {
    steps {
        sh 'docker --version'
        sh 'docker info'
    }
  }

  stage('Compile') {
   steps {
    sh "mvn clean compile"
   }
  }

  stage('Test') {
   steps {
    sh "mvn test"
   }
  }

  stage('Integration Test') {
   steps {
    echo 'From integration test'
   }
  }

  stage('Package') {
   steps {
    sh "mvn package -DskipTests"
   }
  }

  stage('Build Docker Image') {
   steps {
    script {
     dockerImage = docker.build("boris1030/e-books-store:${env.BUILD_TAG}")
    }
   }
  }

  stage('Push Docker Image') {
   steps {
    script {
     docker.withRegistry('', 'dockerhub') {
      dockerImage.push();
      dockerImage.push('latest');
     }
    }
   }
  }
 }

 post {
  always {
   echo 'Im awesome. I run always'
  }
  success {
   echo 'I run when you are successful'
  }
  failure {
   echo 'I run when you fail'
  }
 }
}