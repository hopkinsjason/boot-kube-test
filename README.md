# kubetest
A test of running two services in k*

* Install minikube (and kubectl)
* Run minikube `minikube start`
* You'll need to goto virtual box and change the settings on the vm to give it 4 cpu's and 8gb of ram.
* Restart minikube `minikube stop && minikube start` to pick up the settings
* Once done stop and start minikube 
* use the minikubes docker daemon
  * `eval $(minikube docker-env)` (for linux)
  * or run `minikube docker-dev` and it will give you the command for your OS
* Set up a docker registry within minikube, from the root of the project run:
  * `kubectl -f kube-registry.yaml apply'
  * `./proxy_registry.sh` - sets up a proxy to the docker registry within minikube.  This will block.
* build: `mvn clean install`
* run `./deploy.sh` (anyone fancy writing the windows equivalent?)
* there is no ingress controllers set up (yet), so you need to proxy into the kube cluster:
  * player service:
  * broker:
* run `minikube dashboard` to get the kubernetes dashboard up and running so you can have a play
* if you have enough resources, you can deploy the whole thing again in a different namespace using `./deploy dev'
