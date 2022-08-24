pipeline{
	agent any
	
	environment {
		dockerhubcredentials = 'dockerhubcredentials'
	}
	
	tools {
		git 'Default'
		maven 'Maven3'
		dockerTool 'docker'
	}

	stages{
		stage('Checkout'){
			steps{
			 git branch:'develop' , url:'https://github.com/ankitkawtia-nagarro-sp/app_ankitkawtia.git'
			}
		}
		
		stage('Build'){
			steps {
				bat 'mvn clean install'
			}
		}
		/*stage('Test case execution'){
			steps {
				bat 'mvn test'
			}
		}*/
		stage('Sonarqube Analysis') {
            		steps{
                		withSonarQubeEnv('Test_Sonar') {
                    			bat 'mvn sonar:sonar -Dsonar.projectKey=sonar-ankitkawtia -Dsonar.projectName=sonar-ankitkawtia'
                		}
            		}
        	}
        
        	stage('Docker Build'){
			steps{
				bat 'docker build -t ankitkawtia/i-ankitkawtia-develop:latest . '
			}
		}
		
		stage('Docker push to DockerHub'){
			steps{
				script{
					withDockerRegistry(credentialsId: 'dockerhubcredentials', toolName:'docker'){
						bat 'docker push ankitkawtia/i-ankitkawtia-develop:latest'
					}
				}
			}
		}
		
		/*stage('Docker delete previous container'){
			steps{
				script{
					try{
						bat 'docker rm -f ${docker ps --filter "name=devops-java-app" -aq}'
					}catch(err){
						echo err.getMessage()
					}
				}
			}
		}
		stage('Docker Run Container'){
			steps{
				bat 'docker run -d --name devops-app-develop -p 4042:8081 ankitkawtia/i-ankitkawtia-develop:latest'
			}
		}*/
		
		stage('Kubernetes Deployment'){
		    steps{
		        //bat 'gcloud auth login'
		        //bat 'gcloud container clusters get-credentials kubernetes-demo --zone us-central1-c --project helical-loop-360206'
		        bat 'kubectl apply -f deployment.yaml'
		    }
		}
	}
}
