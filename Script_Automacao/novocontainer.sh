sudo docker start mysql-totem
sudo docker run -it --link mysql-totem --net=totem-net java-image