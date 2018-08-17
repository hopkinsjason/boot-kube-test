#!/bin/bash
kubectl port-forward --namespace default $(kubectl get po -n default | grep broker-service | awk '{print $1;}') 8090:8090
