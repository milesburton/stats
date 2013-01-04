#!/bin/bash

scp build/libs/stats.war deploy@cvps2.agileview.co.uk:~/stats.war
ssh deploy@cvps.milesburton.com "sudo chown tomcat7:tomcat7 /home/miles/stats.war"
ssh deploy@cvps.milesburton.com "sudo rm -rf /var/www/tomcat7/webapps/stats*"
ssh deploy@cvps.milesburton.com "sudo mv /home/deploy/stats.war /var/www/tomcat7/webapps"

