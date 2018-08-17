#!/bin/bash
kubectl port-forward --namespace dev $(kubectl get po -n dev | grep broker-service | awk '{print $1;}') 8190:8090
