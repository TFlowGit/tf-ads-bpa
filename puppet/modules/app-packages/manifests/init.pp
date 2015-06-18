# Packages for the web machine

require epel

class app-packages {
  package { [
    'nginx',
  ]:
    ensure => present,
  }
}