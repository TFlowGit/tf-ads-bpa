
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
