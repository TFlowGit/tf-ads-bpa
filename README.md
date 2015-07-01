[![Build Status](http://18f-dari.techflow.com/jenkins/job/tf-ads-bpa-build/badge/icon)](http://18f-dari.techflow.com/jenkins/job/tf-ads-bpa-build/)

# Prototype

A publicly accessible prototype is hosted at
[http://18f-dari.techflow.com](http://18f-dari.techflow.com/).

# Documentation

* [Maven Site](http://tflowgit.github.io/tf-ads-bpa/1.0-SNAPSHOT/)
* [Swagger API Documents](http://18f-dari.techflow.com/swagger/)
* [SonarQube Reports](http://18f-dari.techflow.com/sonarqube/dashboard/index/1)
* [Javadoc](http://tflowgit.github.io/tf-ads-bpa/1.0-SNAPSHOT/apidocs/index.html)

# Source Code

https://github.com/TFlowGit/tf-ads-bpa.git (branch=master)

# Build from Source

Pre-requisites:
- [Maven](https://maven.apache.org/download.cgi#Installation)
- [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- [OpenJDK](http://openjdk.java.net/install/)

## Java build

To build the project from source, check out the code from GitHub and
build it with Maven. This creates a JAR file that can be run.

    git clone https://github.com/TFlowGit/tf-ads-bpa.git
    cd tf-ads-bpa
    mvn package
    java -jar openfda-web/target/openfda-web-1.0-SNAPSHOT.jar

After the app has finished starting up, browse to
[http://localhost:8080](http://localhost:8080).

## Docker build

Additional prerequisite: [Docker](https://www.docker.com/) must be installed and must work without using `sudo`. On most distributions this means that your user account must be a member of the `docker` group.

Check out the code from GitHub and build it with Maven using the
'docker' profile. This creates a Docker image that can be run.

    git clone https://github.com/TFlowGit/tf-ads-bpa.git
    cd tf-ads-bpa
    mvn -P docker package
    docker run -p 8080:8080 -d techflow/openfda-web

After giving a moment to start up, browse to
[http://localhost:8080](http://localhost:8080).

To stop the container, run `docker stop [container_id]` where
`[container_id]` is the container id printed by the `docker run`
command above.

## Vagrant build

If you choose to build with Vagrant you do not need Java or Maven
installed. The Vagrant file will start up a Fedora 22 VM, install
everything you need, build the application, create a Docker container,
and start it up.

Prerequisites: [Vagrant](https://www.vagrantup.com/) and [VirtualBox](https://www.virtualbox.org/)

Check out the code from GitHub and run `vagrant up` from the main directory as follows:

    git clone https://github.com/TFlowGit/tf-ads-bpa.git
    cd tf-ads-bpa
    vagrant up

After it is done starting up, give it a moment to finish booting the
Tomcat server inside of Docker and browse to
[http://localhost:8080](http://localhost:8080).

Use `vagrant halt` to stop the VM or `vagrant destroy` to delete it.

# Run from Eclipse

    git clone https://github.com/TFlowGit/tf-ads-bpa.git

Import the project into Eclipse (File -> Import -> Existing Maven Projects)

Run the class `com.techflow.openfda.OpenFdaApplication` as Java in the
`openfda-web` project.

Browse to [http://localhost:8080](http://localhost:8080).

# License

All code created for this project is licensed under the CC0
license. Please read [LICENSE.md](LICENSE.md) for details.

Please see [LICENSES.md](LICENSES.md) for a list of all software used
as a part of this project.
