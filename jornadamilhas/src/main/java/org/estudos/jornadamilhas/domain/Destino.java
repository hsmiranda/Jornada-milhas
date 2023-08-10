package org.estudos.jornadamilhas.domain;

import java.math.BigDecimal;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity(name = "tbl_destinos")
@Table(name = "tbl_destinos")
public class Destino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDestino;
    
    @Column(name = "txt_nome_destino")
    private String nomeDestino;
    
    @Column(name = "txt_preco")
    private BigDecimal precoDestino;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "blob_foto_destino", nullable = true)
    private byte[] fotoDestino;

    public Long getIdDestino() {
        return this.idDestino;
    }

    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }

    public String getNomeDestino() {
        return this.nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public BigDecimal getPrecoDestino() {
        return this.precoDestino;
    }

    public void setPrecoDestino(BigDecimal precoDestino) {
        this.precoDestino = precoDestino;
    }

    public byte[] getFotoDestino() {
        return this.fotoDestino;
    }

    public void setFotoDestino(byte[] fotoDestino) {
        this.fotoDestino = fotoDestino;
    }    

    @Override
    public String toString() {
        return "{" +
            " idDestino='" + getIdDestino() + "'" +
            ", nomeDestino='" + getNomeDestino() + "'" +
            ", precoDestino='" + getPrecoDestino() + "'" +
            ", fotoDestino='" + getFotoDestino() + "'" +
            "}";
    }
}