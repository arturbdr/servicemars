# servicemars
Teste de codificação da Elo7.
O teste a ser feito tem como objetivo atender aos requisitos definidos em https://gist.github.com/nirev/fa9e63cfe8251f585611

Para a realização do teste serão realizadas as seguintes atividades:

ToDo
----------
- [ ] Implementação do logback (através do slf4j) com parametrização dos itens a serem logados - Previsão de conclusão :arrow_right: **16/11**
- [ ] Disponinibilizar projeto no SOAPUi para testes dos serviços **17/11**

Done
----------
- [x] Criar projeto no GitHub e respectiva descrição das atividades.
- [x] Informar equipe da Elo7 sobre a URL para acompanhamento do projeto
- [x] Definir camadas da aplicação - Previsão de conclusão :arrow_right: **13/11**
- [x] Implementação das classes de teste e respectivos testes unitários - Previsão de conclusão :arrow_right: **14/11**
- [x] Definição dos serviços a serem expostos - Previsão de conclusão :arrow_right: **15/11**
- [x] Definição do modelo de dados e respectivo framework de persistência - Previsão de conclusão :arrow_right: **15/11**


Definição das Tecnologias Utilizadas no Projeto
----------
- O projeto está sendo codificado em Java versão 7
- Para logs será utilizado framework logback V1.1.3 e serão feitos por aspectos utilizando a nomenclatura do pacote.
- Para controle de dependências e build será utilizado Maven
- Para exposição de serviços (REST) será utilizado Spring.
- Para implementação dos testes unitários será utilizado TestNG V6.9.4 - http://testng.org/doc/index.html
- Para Mock dos testes unitários será utilizado Mockito - 1.10.19 - http://mockito.org/
- A aplicação gera um pacote war. Dependendo do Servidor de Aplicação a ser utilizado para os testes, é necessário realizar o tratamento nas dependências das bibliotecas (tanto para Weblogic como JBoss/WildFly)

Duo Date do projeto
----------
**30/Novembro/2015**
