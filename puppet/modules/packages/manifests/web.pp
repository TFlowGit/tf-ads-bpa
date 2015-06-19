# Packages for the web machine

require epel

class packages::web {
  package { [
    'java-1.8.0-openjdk',
  ]:
    ensure => present,
  }
}