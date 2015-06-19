# Introduction
The scripts in here are for the creation and configuration of the infrastructure used to 
run TechFlow's submission to the 18F Agile Delivery Services BPA.

# Running locally
With Vagrant and VirtualBox installed, run `vagrant up` within this directory.

# Post-Puppet steps
- Within [Jenkins](http://localhost:8081/):
  - Withing 'Configure Global Security', update to require user login for configuration.
  - Under 'Configure System', add a Maven installation. Set the Jenkins URL (if needed).
  - Under 'Credentials', add 'openfda-deploy-key' credentials.
  - Run the job and verify it works.
