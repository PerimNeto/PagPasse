package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

public class LinhaSteps {
    @Dado("que existe uma linha cadastrada com ID {int}")
    public void queExisteUmaLinhaCadastradaComID(int arg0) {
    }

    @Quando("eu enviar uma requisição GET para {string}")
    public void euEnviarUmaRequisiçãoGETPara(String arg0) {
    }

    @E("o corpo da resposta deve conter o nome da linha e rota")
    public void oCorpoDaRespostaDeveConterONomeDaLinhaERota() {
    }
}
