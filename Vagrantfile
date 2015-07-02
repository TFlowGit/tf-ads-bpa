# -*- mode: ruby -*-
# vi: set ft=ruby :

$install_requirements = <<SCRIPT
# For minimal use, updates aren't critical; 
# uncomment if using for anything more than local docker:
# dnf -y update

# Install required software for build:
dnf -y install maven java-1.8.0-openjdk-devel docker

# Ensure Docker is running
systemctl start docker.service

# Enable the 'vagrant' user to access Vagratn without sudo:
groupadd docker
usermod -aG docker vagrant
chown root:docker /var/run/docker.sock
SCRIPT

$build_image = <<SCRIPT
# Use Maven to build the Docker image:
cd /vagrant
mvn -P docker -q clean package
SCRIPT

$run_app = <<SCRIPT
# Start up the Docker image:
docker run -p 8080:8080 -d techflow/openfda-web
SCRIPT


Vagrant.configure(2) do |config|
  config.vm.box = "fedora-22"
  
  config.vm.box_url = "https://download.fedoraproject.org/pub/fedora/linux/releases/22/Cloud/x86_64/Images/Fedora-Cloud-Base-Vagrant-22-20150521.x86_64.vagrant-virtualbox.box"
  config.vm.box_download_checksum = "2513342f70c00310e161a110e34973a133691fedd866859e65904fa056ae7a0c"
  config.vm.box_download_checksum_type = "sha256"
  
  config.vm.define "app" do |app|
    app.vm.network "forwarded_port", guest: 8080, host: 8080
    
    app.vm.provider "virtualbox" do |vb|
      #   # Display the VirtualBox GUI when booting the machine
      #   vb.gui = true
      #
      #   # Customize the amount of memory on the VM:
      #   vb.memory = "6144"
    end
    
    app.vm.provision "shell", inline: $install_requirements
    
    app.vm.provision "shell", inline: $build_image

    app.vm.provision "shell", inline: $run_app
    
  end
  
  
end


