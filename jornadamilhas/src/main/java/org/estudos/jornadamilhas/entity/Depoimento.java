package org.estudos.jornadamilhas.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Depoimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePessoa;
    private String textoDepoimento;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = true)
    private byte[] foto;
   

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return this.nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getTextoDepoimento() {
        return this.textoDepoimento;
    }

    public void setTextoDepoimento(String textoDepoimento) {
        this.textoDepoimento = textoDepoimento;
    }

    public byte[] getFoto() {
        return this.foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nomePessoa='" + getNomePessoa() + "'" +
            ", textoDepoimento='" + getTextoDepoimento() + "'" +
            ", foto='" + getFoto() + "'" +
            "}";
    }

  
    
}
