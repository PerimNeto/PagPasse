#language: pt

Funcionalidade: Cadastro de Cartão de Transporte
Como usuário da API
Quero cadastrar um novo cartão de transporte
Para utilizar o sistema de mobilidade urbana

  Cenário: Cadastro de cartão de transporte com dados válidos
    Dado que estou autenticado na API
    E possuo os seguintes dados válidos para o cartão de transporte:
      | campo          | valor              |
      | numeroCartao   | 1234567890          |
      | tipoCartao     | Comum               |
      | saldoCartao    | 50.00               |
      | dataEmissao    | 2024-04-01           |
    Quando eu enviar uma requisição POST para "/api/cartao-transporte/adicionar"
    Então devo receber uma resposta com status code 200
    E o corpo da resposta deve conter o número do cartão "1234567890"