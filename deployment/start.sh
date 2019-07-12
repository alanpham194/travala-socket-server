#!/usr/bin/env bash
mkdir /home/ubuntu/env/
cd /home/ubuntu/travala/travala-searching
aws s3 cp s3://trav-env/trav-dev2/travala_socket_server_dev.properties /home/ubuntu/env/socket_server.properties
sudo docker-compose down
sudo docker-compose up -d


cd /home/ubuntu/travala/travala-nginx-dev/
git pull origin master
sudo docker-compose -f /home/ubuntu/travala/travala-nginx-dev/docker-compose-dev2.yml restart