#!/bin/bash

scp build/libs/stats.war deploy@cvps2.agileview.co.uk:~/stats.war
ssh deploy@cvps2.agileview.co.uk "sudo chown tomcat7:tomcat7 /home/deploy/stats.war"
ssh deploy@cvps2.agileview.co.uk "sudo rm -rf /var/www/tomcat7/webapps/stats*"
ssh deploy@cvps2.agileview.co.uk "sudo mv /home/deploy/stats.war /var/www/tomcat7/webapps"

