* Disclaimer:
    * Project is not popular, you won't find solution to a lot of problems on the internet
    * It requires access to k8s API, without it won't even work `cannot list resource "pod" in API group in the namespace "demo-projects"`
* JGroup use case - send messages to all replicas of a pod.
* Alternative to redis pub/sub. Main advantage - no need to complicate infrastructure.
* Two configs - for local launch and for kubernetes
