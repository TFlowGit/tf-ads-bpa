#

class proxy_config {
  require base_config

  File {
    require => Package[ 'nginx' ],
    owner => root,
    group => root,
    mode  => '640',
    notify  => Exec['service nginx restart'],
  }

  file { '/etc/nginx/nginx.conf': 
    ensure  => present,
    content => template("proxy_config/nginx.conf.erb"),
  }

  file { '/etc/nginx/conf.d/default.conf': 
    ensure  => present,
    content => template("proxy_config/default.conf.erb"),
  }

  exec { 'service nginx restart':
    path        => [ '/sbin', '/bin', '/usr/bin' ],
    refreshonly => true,
  }

  selboolean { 'selinux allow proxying': 
    name => 'httpd_can_network_connect',
    value => on,
    persistent => true,
    require => Class[selinux],
  }

}