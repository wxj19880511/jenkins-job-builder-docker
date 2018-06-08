docker run -it --rm --net=host \
    -v jenkins_jobs.ini:/etc/jenkins_jobs/jenkins_jobs.ini \
    -v $(pwd):/root/jenkins-job-builder \
    diabol/jenkins-job-builder jenkins-jobs update my_job_config.yaml
