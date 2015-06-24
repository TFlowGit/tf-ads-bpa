# Packages and other base config for the build machine

require base_config

class base_config::build {
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