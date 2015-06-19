# Packages for the web machine

require epel

class packages::build {
  package { [
      'java-1.8.0-openjdk',
      'java-1.8.0-openjdk-devel',
      'puppet-server',
      'git',
    ]:
    ensure => present,
  }
  
  # Make sure we use the correct JDK:
  package { [
      'java-1.7.0-openjdk-devel',
      'java-1.7.0-openjdk',
    ]:
    ensure => absent,
  }
}