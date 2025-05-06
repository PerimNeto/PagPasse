package br.com.fiap.PagPasse.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tbl_notificacao")
public class Notificacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoNotificacao;

    private String mensagem;

    private Date dataEnvio;

    private String email;


    //------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //------------------------------------------------------------
    public String getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(String tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }
    //------------------------------------------------------------
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    //------------------------------------------------------------
    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    //------------------------------------------------------------
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notificacao notificacao = (Notificacao) o;
        return Objects.equals(id, notificacao.id) && Objects.equals(tipoNotificacao, notificacao.tipoNotificacao) && Objects.equals(mensagem, notificacao.mensagem) && Objects.equals(dataEnvio, notificacao.dataEnvio) && Objects.equals(email, notificacao.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoNotificacao, mensagem, dataEnvio, email);
    }

}
