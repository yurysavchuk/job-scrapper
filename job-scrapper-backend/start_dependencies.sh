#!/bin/bash
docker run --rm -d --name postgres-jobscrapper -e POSTGRES_DB=vacancies -e POSTGRES_USER=jobscrapper -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 postgres:13.1