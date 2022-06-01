#!/usr/bin/env bash

#-VARIAVEIS INFO-----------------------------------------------------#

NOME_PROGRAMA="$(basename $0 | cut -d. -f1)"
VERSAO="1.0"
AUTOR="Totem System"
CONTATO="https://github.com/leticiaNCosta18/TotemSystem"
DESCRICAO="Script para executar o .jar do projeto"
varEXE=$1 # Se não tiver parametros ela executa normal


#-VARIAVEIS PARAMETRO----------------------------------------------------#

varINFO="
Nome do Programa: $NOME_PROGRAMA
Autor: $AUTOR
Versão: $VERSAO
Descrição do Programa: $DESCRICAO
"
varHELP="
Instruções para Ajuda:
	-h ou --help: Abre a ajuda de comandos do usuário;
	-i ou --info: Informações sobre o programa;
"

#-TESTES--------------------------------------------------------------------------#



#-LOOP PARA RODAR MAIS PARAMETROS---------------------------------------------------#

while test -n "$1"; do

	case $1 in

		-i |  --info)  	echo "$varINFO" 											;;		
		-h |  --help)  	echo "$varHELP"												;;
		-d | --debug)	bash -x $0													;;
		 *) 	echo "\nComando inválido. Digite -h ou --help para ajuda\n"	;;

	esac
	shift

done
#-FUNÇÕES--------------------------------------------------------------------------#

instalar_pacotes(){

	echo "\n\n=================================================="
	echo "Instalando e verificando todos os pacotes..."
	echo "==================================================\n\n"
	sleep 1
	echo "\n\n=================================================="
	echo "Dando update nos arquivos..."
	echo "==================================================\n\n"
	sudo apt-get update && sudo apt-get upgrade -y
	#echo "\n\n=================================================="
	#echo "Verificando java..."
	#echo "==================================================\n\n"
	#[ ! -x $(which java) ] && sudo apt-get install openjdk-11-jdk -y
	#sudo apt-get install xrdp lxde-core lxde tigervnc-standalone-server -y
	#echo "\n\n=================================================="
	#echo "Verificando git..."
	#echo "==================================================\n\n"
	#[ ! -x $(which git) ] && sudo apt-get install git-all
	echo "\n\n=================================================="
	echo "Verificando docker..."
	echo "==================================================\n\n"
	sudo apt install docker.io -y


}
criar_urubu100(){

	echo "\n\n=================================================="
	echo "Criando usuário urubu100.."
	echo "==================================================\n\n"
	useradd -m -U urubu100
	echo "urubu100:urubu100" | chpasswd 
	echo "\n\n=================================================="
	echo "Dando permissão de sudo para urubu100..."
	echo "==================================================\n\n"
	usermod -aG sudo urubu100
	

}
clonar_github(){

	echo "\n\n=================================================="
	echo "Baixa o .jar"
	echo "==================================================\n\n"
	wget -O TotemSystemCLI.jar https://github.com/Don616/sptech/raw/main/Script_Automacao/java/TotemSystemCLI.jar 
	chmod 777 TotemSystemCLI.jar
	echo "\n\n=================================================="
	echo "Criando uma pasta para o projeto..."
	echo "==================================================\n\n"
	mkdir totem && mv ./TotemSystemCLI.jar totem/TotemSystemCLI.jar && cd totem


}
instalar_docker(){

	echo "\n\n=================================================="
	echo "Permissões ao docker"
	echo "==================================================\n\n"
	sudo systemctl start docker
	sudo systemctl enable  docker
	#echo "\n\n=================================================="
	#echo "Instalando docker compose"
	#echo "==================================================\n\n"
	#sudo apt install docker-compose -y
	#echo "\n\n=================================================="
	#echo "Fazendo o build do Docker Compose..."
	#echo "==================================================\n\n"
	#sudo docker-compose up --no-start --build
	echo "\n\n=================================================="
	echo "Criando uma network..."
	echo "==================================================\n\n"
	sudo docker network create totem-net
	echo "\n\n=================================================="
	echo "Rodando mysql no Docker"
	echo "==================================================\n\n"
	sudo docker build -t mysql-image ./mysql/.
	sudo docker run -d --name mysql-totem -p 3306:3306 --net=totem-net mysql-image
	echo "\n\n=================================================="
	echo "Rodando java no Docker"
	echo "==================================================\n\n"
	sudo docker build -t java-image ./java/.
	sudo docker start mysql-totem
	sudo docker run -it --name java-totem --link mysql-totem --net=totem-net java-image                                                           
	sudo docker run -it --link mysql-totem --net=totem-net java-image
}

main(){

	criar_urubu100
	clear
	instalar_pacotes
	clear
	clonar_github
	clear
	baixar_scripts
	clear
	instalar_docker
	

}

baixar_scripts(){

	mkdir mysql
	mkdir java
	#wget -O docker-compose.yml https://github.com/leticia-NCosta/TotemSystem/raw/main/Script_Automacao/docker-compose.yml
	wget -O Dockerfile https://raw.githubusercontent.com/Don616/sptech/main/Script_Automacao/java/Dockerfile
	mv ./Dockerfile ./java/Dockerfile
	wget -O Dockerfile https://raw.githubusercontent.com/Don616/sptech/main/Script_Automacao/mysql/Dockerfile
	mv ./Dockerfile ./mysql/Dockerfile
	wget -O sql.sql https://raw.githubusercontent.com/Don616/sptech/main/Script_Automacao/mysql/sql.sql
	mv ./sql.sql ./mysql/sql.sql
	mv ./TotemSystemCLI.jar ./java/TotemSystemCLI.jar
	

}

#-EXECUÇÃO-------------------------------------------------------------------------#

if [ -z "$varEXE" ]; then
	# Coloca o main do programa aqui
	main
fi
