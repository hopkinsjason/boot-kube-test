#!/bin/bash
kubectl port-forward --namespace default $(kubectl get po -n default | grep player-service | awk '{print $1;}') 8080:8080
