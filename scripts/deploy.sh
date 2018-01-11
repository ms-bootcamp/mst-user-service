#! /usr/bin/env bash
set -x
set -e

if [[ -z $DOCKER_REGISRTY ]]; then
  DOCKER_REGISRTY=127.0.0.1:5000
fi
IMAGE_NAME=${DOCKER_REGISRTY}/tw-ms-train/user-service:${GO_PIPELINE_COUNTER}

docker run -d -p 8080:8080 $IMAGE_NAME