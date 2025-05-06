#language: pt


Funcionalidade: Consulta de Linha
  Como usuário da API
  Quero consultar uma linha de transporte cadastrada
  Para visualizar informações de rota e horários

  Cenário: Buscar linha existente pelo ID
    Dado que existe uma linha cadastrada com ID 1
    Quando eu enviar uma requisição GET para "/api/linha/1"
    Então devo receber uma resposta com status code 200
    E o corpo da resposta deve conter o nome da linha e rota