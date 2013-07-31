<VirtualHost *:80>                                                                                                                                                                   
        ServerAdmin webmaster@razerstats.com                                                                                                                                             
        ServerName api.razerstats.com                                                                                                                                                  
                                                                                                                                                                                     
        JKMount /stats-api/* ajp13_worker                                                                                                                                  
        JKMount /stats-api ajp13_worker                                                                                                                                    
                                                                                                                                                                                     
                                                                                                                                                                                     
        ProxyRequests Off                                                                                                                                                            
        ProxyPreserveHost On                                                                                                                                                         
                                                                                                                                                                                     
        ProxyPass / ajp://localhost:8009/stats-api/                                                                                                                        
        ProxyPassReverse / ajp://localhost:8009/stats-api/                                                                                                                 
                                                                                                                                                                                     
        Header edit Location "^http://api.nzbair.com/stats-api/(.*)$" "http://api.stats.com/$1"                                                                       
                                                                                                                                                                                     
        ProxyHTMLExtended On                                                                                                                                                         
        SetOutputFilter DEFLATE;proxy-html;INFLATE                                                                                                                                   
        ProxyHtmlURLMap /stats-api/ /                                                                                                                                      
                                                                                                                                                                                     
        ErrorLog  /var/www/api.razerstats.com/logs/error.log                                                                                                                           
        CustomLog /var/www/api.razerstats.com/logs/access.log combined                                                                                                                 
</VirtualHost>    