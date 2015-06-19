# Packages for the web machine

require epel

class packages::app {
  package { [
    'nginx',
  ]:
    ensure => present,
  }
}