package br.com.fiap.PagPasse.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tbl_linha")
public class Linha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeLinha;
    private String rota;
    private Date tempoEstimado;
    private String localizacaoAtual;

    private Date dataUltimaAtualizacao;

    private Date horarioInicio;
    private Date horarioFim;

    //------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //------------------------------------------------------------
    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }
    //------------------------------------------------------------
    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }
    //------------------------------------------------------------
    public Date getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Date tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
    //------------------------------------------------------------
    public String getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public void setLocalizacaoAtual(String localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }
    //------------------------------------------------------------
    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
    //------------------------------------------------------------
    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }
    //------------------------------------------------------------
    public Date getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Date horarioFim) {
        this.horarioFim = horarioFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linha linha = (Linha) o;
        return Objects.equals(id, linha.id) && Objects.equals(nomeLinha, linha.nomeLinha) &&
                Objects.equals(rota, linha.rota) && Objects.equals(tempoEstimado, linha.tempoEstimado) &&
                Objects.equals(localizacaoAtual, linha.localizacaoAtual) &&
                Objects.equals(dataUltimaAtualizacao, linha.dataUltimaAtualizacao) &&
                Objects.equals(horarioInicio, linha.horarioInicio) &&
                Objects.equals(horarioFim, linha.horarioFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeLinha, rota, tempoEstimado, localizacaoAtual,
                dataUltimaAtualizacao, horarioInicio, horarioFim);
    }
}
