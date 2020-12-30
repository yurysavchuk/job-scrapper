#!/bin/bash
docker run --rm -d --name postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 postgres:13.1