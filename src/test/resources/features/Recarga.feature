#language: pt

Funcionalidade: Recarga de Saldo
  Como usuário da API
  Quero recarregar meu saldo
  Para continuar usando o transporte público

  Cenário: Tentativa de recarga com valor negativo
    Dado que estou autenticado na API
    E tento recarregar o saldo com um valor negativo "-10.00"
    Quando eu enviar uma requisição POST para "/api/recarga/adicionar"
    Então devo receber uma resposta com status code 400
    E uma mensagem de erro informando "O valor da recarga deve ser positivo"