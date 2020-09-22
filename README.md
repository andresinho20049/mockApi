# **************** Mock API ******************
### API desenvolvida para teste do GuiaBolso: 
[Click aqui](https://github.com/GuiaBolso/seja-um-guia-back/tree/master) para acessar!
Tecnologia utilizada: Java 8 + Spring boot + Rest + log4j + Docker

**Sobre:**

- API de mock de Transações, baseado no response JSON abaixo:
    ```json
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
    ```

- As requisições da API são HTTP utilizando Rest Service:
- API não faz nenhuma consulta no banco de dados, todos os valores retornados vem direto de um arquivo: **-mock.json*
- Foi criado imagem docker baseado no *openjdk:8* e as portas *8080* para Tomcat e *5005* para debbug no docker estão abertas
	
**Métodos:**
- [get /api/{id}](https://mockapi-heroku.herokuapp.com/api/1001) - Consulta de todas as transacoes do ID informado no path
- [get /api/{id}/transacoes/{ano}](https://mockapi-heroku.herokuapp.com/api/1001/transacoes/2020) - Consulta das transacoes do id informado no path filtrando o ano
- [get /api/{id}/transacoes/{ano}/{mes}](https://mockapi-heroku.herokuapp.com/api/1001/transacoes/2020/1) - Consulta das transacoes do id informado no - path filtrando o ano e mês
- post /api/{id} - Save de nova transacao
	
	
**Teste Disponivel no Heroku:**
https://mockapi-heroku.herokuapp.com/api/1001


> **Inspirações:**   
> Marcos Caldeira *(Meu grande mentor)*  
> canal do [Rodrigo Rahman](https://www.youtube.com/channel/UC5hvPObwya8kzWWB-wmVlXg)