# app_ankitkawtia

# Running with Jenkins Pipeline
Run the pipeline on Jenkins using Jenkinsfile

# Docker commands
## Spin a image into a container
docker run -d --name devops-app-master -p 4042:8083 ankitkawtia/i-ankitkawtia-master:latest

# Login to docker hub to push the image
docker login

# Push image
docker push ankitkawtia/i-ankitkawtia-master:latest

# Kubernetes deployment 
## Create namespace
kubectl apply -f namespace.yaml

## Create ConfigMap
kubectl apply -f configmap.yaml

## Create Secrets
kubectl apply -f secrets.yaml

## Deploy the docker image and create load balancer service on Kubernetes cluster
kubectl apply -f deployment.yaml

## See the deployment details in custom namespace
kubectl describe deployment devopsapp-deployment-master -n kubernetes-cluster-ankitkawtia

## See all the workload details in custom namespace
kubectl get all -n kubernetes-cluster-ankitkawtia
