pipeline {
    agent {label 'slave-maven'}
    stages {
        stage('Install dependencies') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('config'){
            steps{
                script {
                    if (env.BRANCH_NAME == 'dev') {
                        env.SSH_PUBLISHER = 'travala_dev_server'
                        env.START_FILE='start.sh'
                    }
                    if (env.BRANCH_NAME == 'staging') {
                        env.START_FILE = 'start_staging.sh'
                        env.SSH_PUBLISHER = 'travolutionary_staging'
                    }
                    if (env.BRANCH_NAME == 'master') {
                        env.SSH_PUBLISHER = 'undefine'
                    }
                }
            }
        }

        stage('Deploy to server'){
            steps{
                script {
                    sshPublisher(
                        publishers:[
                            sshPublisherDesc(configName:"$env.SSH_PUBLISHER",verbose:true,transfers:[
                                sshTransfer(
                                    sourceFiles:"target/socket.war",
                                    remoteDirectory:"travala-socket-server",
                                    removePrefix:"target/"
                                ),
                                sshTransfer(
                                    sourceFiles:"docker-compose.yml",
                                    remoteDirectory:"travala-socket-server"
                                ),
                                sshTransfer(
                                   sourceFiles:"deployment/$env.START_FILE",
                                   remoteDirectory:"travala-socket-server",
                                   removePrefix: "deployment/"
                                ),
                                sshTransfer(
                                    //exec commands
                                    execCommand: "chmod +x /home/ubuntu/travala/travala-socket-server/$env.START_FILE & /home/ubuntu/travala/travala-socket-server/$env.START_FILE"
                                )
                            ])
                        ]
                    )
                }
            }
        }
    }
}