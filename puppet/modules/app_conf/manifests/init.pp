# set up places for for the app to run

class app_conf {
  group{ 'tf-ads-bpa':
    ensure => present,
  }->
  user{ 'tf-ads-bpa':
    ensure     => present,
    groups     => 'tf-ads-bpa',
    managehome => true,
  }->
  file { [ '/home/tf-ads-bpa/app', '/home/tf-ads-bpa/logs' ]:
    ensure => directory,
    owner  => 'tf-ads-bpa',
    group  => 'tf-ads-bpa',
  }
  file { '/etc/init/tf-ads-bpa.conf':
    content => template("app_conf/tf-ads-bpa.conf.erb"),
  }
}
