# Dockerized Jenkins Job Builder
Docker image containing [Jenkins Job Builder](https://docs.openstack.org/infra/jenkins-job-builder/) (JJB).

When configuring [Jenkins](https://jenkins.io/) it is preferable to store your job configuration as source code and to version control them. Jenkins Job Builder is a tool that allows you to specify Jenkins jobs in a yaml format. You can then use Jenkins Job Builder to configure your Jenkins instance based on these configurations. Instead of requiring you to install Jenkins Job Builder on your machine, you could run it in a Docker container.

You need to configure a jenkins.ini configuration file for Jenkins Job Builder with information on how to connect to your Jenkins instance. See the provided example [jenkins_jobs.ini](https://github.com/Diabol/jenkins-job-builder-docker/blob/master/jenkins_jobs.ini). Volume mount the directory containing your job configuration files to the Docker container, and then invoke Jenkins Job Builder ising the jenkins-jobs command, such as:

    docker run -it --rm --net=host -v jenkins_jobs.ini:/etc/jenkins_jobs/jenkins_jobs.ini -v PATH_TO_JOB_CONFIGS:/root/jenkins-job-builder diabol/jenkins-job-builder jenkins-jobs update my_job_config.yaml

The Docker image is available on [Docker Hub](https://hub.docker.com/r/diabol/jenkins-job-builder/).



#!/bin/bash


pwd && ls

git clone git@github.com:wxj19880511/jenkins-job-builder-docker.git CIHOME
git clone git@github.com:wxj19880511/QTConfiguration.git
pwd && ls

find . -name "*.groovy"


# Below is not visiable for the QT tester
# Once the QT Configuraotn repo was added a 
# new folder for a a new stream, change nothing
# for below job for:
#
# WFT:
# Always scan the configuration file directory 
# and sync the WFT to data base.

# QT Trigger:
# Always scan the configuration directory and trigger 
# And return the latest build list for each stream.

# Sync data fro WFT to database 
WFT Trigger (MCJ)  -> independent tag 
WFT independent Repo (QT Configuration)

# Return all
QT Trigger Trigger (MCJ)  -> independent tag
QT Trigger independent Repo (QT Configuration)


