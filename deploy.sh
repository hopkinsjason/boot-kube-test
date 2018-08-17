#!/bin/bash

namespace="default"

if [[ -n $1 ]]; then
  namespace=$1
fi

echo Using namespace ${namespace}

kubectl -f postgres/postgres.yaml apply --namespace=$namespace

kubectl delete configmap player-service --namespace=$namespace
kubectl create configmap player-service --from-env-file=player-service/src/main/resources/config/${namespace}/config.conf --namespace=$namespace
kubectl -f player-service/player-service.yaml apply --namespace=$namespace

kubectl delete configmap broker-service --namespace=$namespace
kubectl create configmap broker-service --from-env-file=broker/src/main/resources/config/${namespace}/config.conf --namespace=$namespace
kubectl -f broker/broker-service.yaml apply --namespace=$namespace