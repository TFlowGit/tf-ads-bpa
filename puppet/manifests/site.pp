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
  include epel
}

node bastion {
  include epel
}

node puppet {
  include epel
  include packages::build
  include firewall::build
  include jenkins_conf
}

node /^app\d+$/ {
  include epel
  include packages::app
  include firewall::app
}

node /^web\d+$/ {
  include epel
  include packages::web
  include firewall::web
}
