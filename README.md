# app_ankitkawtia

## Running with Jenkins Pipeline
Run the pipeline on Jenkins using Jenkinsfile

# Kubernetes deployment 
## Create namespace
kubectl apply -f namespace.yaml

## Create ConfigMap
kubectl apply -f configmap.yaml

## Create Secrets
kubectl apply -f secrets.yaml

## Deploy the docker image and create load balancer service on Kubernetes cluster
kubectl apply -f deployment.yaml

## See the deployment details
kubectl describe deployment devopsapp-deployment

## See all the workload details in default namespace
kubectl get all

## See all the workload details in custom namespace
kubectl get all -n kubernetes-cluster-ankitkawtia
