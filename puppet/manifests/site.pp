# # site.pp ##

# This file (/etc/puppetlabs/puppet/manifests/site.pp) is the main entry point
# used when an agent connects to a master and asks for an updated configuration.
#
# Global objects like filebuckets and resource defaults should go in this file,
# as should the default node definition. (The default node can be omitted
# if you use the console and don't define any other nodes in site.pp. See
# http://docs.puppetlabs.com/guides/language_guide.html#nodes for more on
# node definitions.)

# # Active Configurations ##

# Make filebucket 'main' the default backup location for all File resources:
File {
  backup => 'main'
}


node default {
}

node build {
  include epel
  include packages::build
  include jenkins_conf
  include firewall::build
}

node app {
  include epel
  include packages::app
}

node web {
  include epel
  include packages::web
}
