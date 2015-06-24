# Packages and other base config for the app machine

require epel

class base_config {

  class { selinux:
    mode => 'enforcing'
  }

  package { [
    'vim-common',
  ]:
    ensure => present,
  }

}