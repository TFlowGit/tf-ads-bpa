# Packages and other base config for the web machine

require base_config

class base_config::web {
  package { [
    'nginx',
    'squid',
  ]:
    ensure => present,
  }
  
  
}