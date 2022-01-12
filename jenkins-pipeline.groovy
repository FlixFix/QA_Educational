pipeline {
    agent { label 'psa-build-node-centos' }
    options {
        timeout(time: 1, unit: 'HOURS')
        buildDiscarder(logRotator(numToKeepStr: '20'))
    }
    environment {
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk'
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn install -DskipTests'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test -Dmaven.test.failure.ignore=true'
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

}