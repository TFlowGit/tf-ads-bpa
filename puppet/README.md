# Introduction
The scripts in here are for the creation and configuration of the infrastructure used to 
run TechFlow's submission to the 18F Agile Delivery Services BPA.

# Running with Vagrant
With Vagrant and VirtualBox installed, run `vagrant up` within this directory.

# Normal install
Bootstrapping Puppet:
* `yum install epel-release` (I had to edit `epel.conf` because mirrors were broken.)
* `rpm -ivh http://yum.puppetlabs.com/puppetlabs-release-el-6.noarch.rpm`
* `yum install puppet-server git`
* Check repo out to `/srv/puppet` and configure `puppet.conf` to look at it.

# Post-Puppet steps
Configure [Jenkins](http://localhost:8081/):
- Withing 'Configure Global Security', update to require user login for configuration.
- Under 'Configure System', add a Maven installation. Set the Jenkins URL (if needed).
- Under 'Credentials', add 'openfda-deploy-key' credentials.
- Run the job and verify it works.

