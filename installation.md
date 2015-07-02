# Build from Source

## Which method to use

- If you do not have experience building Java applications or do not
  wish to install the necessary build chain, use the Vagrant method.
- If you have Java and Maven installed (or know how to do so), use the
  Java or Docker build instructions.
- If you wish to create a Docker image (possibly for deployment to a
  production environment) follow the Docker build instructions.
- If you wish to develop the application within Eclipse, use the
  Eclipse instructions.

## Notes for prodction deployment

- The application runs on port 8080. All methods below preserve this.
- The Vagrant method is intended for development only. If you intend
  to deploy the VM it creates to a production environment be sure to
  un-comment the `dnf update` command any apply any relevant hardening
  to the image.
- You will want to set up a reverse proxy server to provide the
  application on a standard HTTP and/or HTTPS port(s).

## Java build

### Pre-requisites:
- [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- [OpenJDK](http://openjdk.java.net/install/)
- [Maven](https://maven.apache.org/download.cgi#Installation)

### Build instructions
1. Check out the code: `git clone
   https://github.com/TFlowGit/tf-ads-bpa.git`
2. Change to the code directory: `cd tf-ads-bpa`
3. Build the application: `mvn package`

### Running the application

Start the application with the command
`java -jar openfda-web/target/openfda-web-1.0-SNAPSHOT.jar`

After the app has finished starting up, browse to
[http://localhost:8080](http://localhost:8080).

Use `Ctrl-C` to terminate the application when you are finished with
it.

For production use you will want to copy the
`openfda-web-1.0-SNAPSHOT.jar` file to your server and run the
`java -jar openfda-web-1.0-SNAPSHOT.jar` command from an unpriviledged
account.


## Docker build

Note that Docker requires you to be running on a Linux system or to
use [boot2docker](http://boot2docker.io/). Alternatively you may use
the Vagrant build instructions provided elsewhere in this file.

### Pre-requisites:
- [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- [OpenJDK](http://openjdk.java.net/install/)
- [Maven](https://maven.apache.org/download.cgi#Installation)
- [Docker](https://www.docker.com/) must be installed and must work
  without using `sudo`. On most distributions this means that your
  user account must be a member of the `docker` group. You may also
  need to change the file `/var/run/docker.sock` to be owned by the
  `docker` group.

### Build instructions
1. Check out the code: `git clone
   https://github.com/TFlowGit/tf-ads-bpa.git`
2. Change to the code directory: `cd tf-ads-bpa`
3. Build the application using the `docker` profile:
   `mvn -P docker package`

### Running the application

Start the application with the command
`docker run -p 8080:8080 techflow/openfda-web`

After the app has finished starting up, browse to
[http://localhost:8080](http://localhost:8080).

Use `Ctrl-C` to terminate the application/container when you are
finished with it.

For production use you may either export the application to Docker Hub
and import to your server from there or you can export the image to a
file and import to your server.

## Vagrant build

### Prerequisites:
- [Vagrant](https://www.vagrantup.com/)
- [VirtualBox](https://www.virtualbox.org/)

### Build instructions:
1. Check out the code: `git clone
   https://github.com/TFlowGit/tf-ads-bpa.git`
2. Change to the code directory: `cd tf-ads-bpa`
3. Build and run the application: `vagrant up`

After it is done starting up, give it another moment to finish booting
the Tomcat server inside of Docker and browse to
[http://localhost:8080](http://localhost:8080).

Use `vagrant halt` to stop the VM or `vagrant destroy -f` to delete it.

## Run from Eclipse

1. Check out the code: `git clone
   https://github.com/TFlowGit/tf-ads-bpa.git`
2. Import the project into Eclipse (File -> Import -> Existing Maven
   Projects)
3. Run the class `com.techflow.openfda.OpenFdaApplication` as Java in
   the `openfda-web` project.

Browse to [http://localhost:8080](http://localhost:8080) after the
server has started up.
