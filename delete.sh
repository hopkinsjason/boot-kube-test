#!/bin/bash

namespace="default"

if [[ -n $1 ]]; then
  namespace=$1
fi

echo Using namespace ${namespace}

kubectl -f postgres/postgres.yaml delete --namespace=$namespace

kubectl delete configmap player-service --namespace=$namespace
kubectl -f player-service/player-service.yaml delete --namespace=$namespace

kubectl delete configmap broker-service --namespace=$namespace
kubectl -f broker/broker-service.yaml delete --namespace=$namespace