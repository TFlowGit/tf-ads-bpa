# Packages for the web machine

require epel

class build-packages {
  package { [
    'java-1.8.0-openjdk',
  ]:
    ensure => present,
  }
}