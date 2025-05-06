package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CartaoTransporteSteps {
    @Dado("que estou autenticado na API")
    public void queEstouAutenticadoNaAPI() {
    }

    @E("possuo os seguintes dados válidos para o cartão de transporte:")
    public void possuoOsSeguintesDadosVálidosParaOCartãoDeTransporte() {
    }

    @Quando("eu enviar uma requisição POST para {string}")
    public void euEnviarUmaRequisiçãoPOSTPara(String arg0) {
    }

    @Então("devo receber uma resposta com status code {int}")
    public void devoReceberUmaRespostaComStatusCode(int arg0) {
    }

    @E("o corpo da resposta deve conter o número do cartão {string}")
    public void oCorpoDaRespostaDeveConterONúmeroDoCartão(String arg0) {
    }
}
