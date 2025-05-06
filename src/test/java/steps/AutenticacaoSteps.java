package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AutenticacaoSteps {
    @Dado("que estou na página de login e possuo as seguintes credenciais válidas:")
    public void queEstouNaPáginaDeLoginEPossuoAsSeguintesCredenciaisVálidas() {
    }

    @Quando("eu enviar a requisição de autenticação")
    public void euEnviarARequisiçãoDeAutenticação() {
    }

    @Então("devo ser redirecionado para o painel de controle e devo visualizar uma mensagem de boas-vindas")
    public void devoSerRedirecionadoParaOPainelDeControleEDevoVisualizarUmaMensagemDeBoasVindas() {
    }

    @Dado("que estou na página de login e possuo as seguintes credenciais inválidas:")
    public void queEstouNaPáginaDeLoginEPossuoAsSeguintesCredenciaisInválidas() {
    }

    @Então("devo visualizar a mensagem de erro {string}")
    public void devoVisualizarAMensagemDeErro(String arg0) {
    }

    @Dado("que não estou autenticado no sistema")
    public void queNãoEstouAutenticadoNoSistema() {
    }

    @Quando("eu tentar acessar o endpoint {string}")
    public void euTentarAcessarOEndpoint(String arg0) {
    }

    @Então("devo receber a resposta com status code {int} Não Autorizado")
    public void devoReceberARespostaComStatusCodeNãoAutorizado(int arg0) {
    }
}
