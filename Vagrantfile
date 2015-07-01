# -*- mode: ruby -*-
# vi: set ft=ruby :

$install_requirements = <<SCRIPT
dnf -y update
dnf -y install maven java-1.8.0-openjdk-devel docker
systemctl start docker.service
groupadd docker
usermod -aG docker vagrant
chown root:docker /var/run/docker.sock
SCRIPT

$build_image = <<SCRIPT
cd /vagrant
mvn -P docker clean package
SCRIPT

$run_app = <<SCRIPT
docker run -p 8080:8080 -d techflow/openfda-web
SCRIPT


Vagrant.configure(2) do |config|
  config.vm.box = "box-cutter/fedora22"
  config.vm.box_check_update = true
    
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


