****************Mock API***********************
API desenvolvida para teste do GuiaBolso: https://github.com/GuiaBolso/seja-um-guia-back/tree/master

Tecnologia utilizada: Java 8 + Spring boot + Rest + log4j + Docker

Sobre:
	- API de mock de Transações, baseado no response JSON abaixo:
	[
	  {
		 "descricao": "Compass to GuiaBolso",
		 "data": 20200918030839,
		 "valor": 500000,
		 "duplicated": false
	  },
	  {
		 "descricao": "GuiaBolso to EvilCorp(Mr Robot)",
		 "data": 20200918030846,
		 "valor": 550000,
		 "duplicated": false
	  }
	]
	
	-As requisições da API são HTTP utilizando Rest Service
	
	-API não faz nenhuma consulta no banco de dados, todos os valores retornados vem direto de um arquivo: *-mock.json
	
	-Foi criado imagem docker baseado no openjdk:8 e as portas 8080 para Tomcat e 5005 para debbug no docker estão abertas
	

Inspirações de código:
	-Marcos Caldeira(Meu grande mentor)
	-canal do Rodrigo Rahman https://www.youtube.com/channel/UC5hvPObwya8kzWWB-wmVlXg