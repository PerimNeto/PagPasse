#language: pt

Funcionalidade: Autenticação de Usuário
Como usuário da API
Quero autenticar minhas credenciais
Para acessar recursos protegidos do sistema

  Cenário: Login bem-sucedido com credenciais válidas
    Dado que estou na página de login e possuo as seguintes credenciais válidas:


      |campo        | valor    |
      |nomeUsuario	| Usuário  |
      |senha	    | Senha    |
    Quando eu enviar a requisição de autenticação
    Então devo ser redirecionado para o painel de controle e devo visualizar uma mensagem de boas-vindas


  Cenário: Login mal-sucedido com credenciais inválidas
    Dado que estou na página de login e possuo as seguintes credenciais inválidas:


      |campo	    | valor              |
      |nomeUsuario	| Usuário Inválido   |
      |senha	    | Senha Inválida     |
    Quando eu enviar a requisição de autenticação
    Então devo visualizar a mensagem de erro "Credenciais inválidas"


  Cenário: Tentativa de acesso a recurso privado sem autenticação
    Dado que não estou autenticado no sistema
    Quando eu tentar acessar o endpoint "/api/private/hello"
    Então devo receber a resposta com status code 401 Não Autorizado