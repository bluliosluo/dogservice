#!/bin/bash
set -x

awslocal sqs create-queue --queue-name demo-queue
awslocal s3 mb s3://demo-bucket
set +x