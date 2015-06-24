# Packages and other base config for the app machine

require base_config


class base_config::app {
  package { [
    'java-1.8.0-openjdk',
    'java-1.8.0-openjdk-devel',
  ]:
    ensure => present,
  }
}