#!/bin/bash

docker build --tag rcarvajalf/sofkatracingapi:0.0.2 .

docker push rcarvajalf/sofkatracingapi:0.0.2
