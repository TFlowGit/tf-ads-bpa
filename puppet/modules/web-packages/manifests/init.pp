# Packages for the web machine

require epel

class web-packages {
  package { [
    'java-1.8.0-openjdk',
  ]:
    ensure => present,
  }
}