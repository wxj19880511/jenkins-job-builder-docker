FROM python3

WORKDIR /root
RUN pip install jenkins-job-builder

ADD jenkins_jobs.ini /etc/jenkins_jobs/jenkins_jobs.ini
WORKDIR /root/jenkins-job-builder
