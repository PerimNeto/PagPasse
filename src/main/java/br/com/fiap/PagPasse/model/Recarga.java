package br.com.fiap.PagPasse.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tbl_recarga")
public class Recarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float valorRecarga;

    private String metodoPagamento;

    private Date dataRecarga;

    private Boolean status;

    //------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //------------------------------------------------------------
    public Float getValorRecarga() {
        return valorRecarga;
    }

    public void setValorRecarga(Float valorRecarga) {
        this.valorRecarga = valorRecarga;
    }
    //------------------------------------------------------------
    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    //------------------------------------------------------------
    public Date getDataRecarga() {
        return dataRecarga;
    }

    public void setDataRecarga(Date dataRecarga) {
        this.dataRecarga = dataRecarga;
    }

    //------------------------------------------------------------
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recarga recarga = (Recarga) o;
        return Objects.equals(id, recarga.id) && Objects.equals(valorRecarga, recarga.valorRecarga) && Objects.equals(metodoPagamento, recarga.metodoPagamento) && Objects.equals(dataRecarga, recarga.dataRecarga) && Objects.equals(status, recarga.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valorRecarga, metodoPagamento, dataRecarga, status);
    }
}
