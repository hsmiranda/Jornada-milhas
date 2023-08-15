package org.estudos.jornadamilhas.domain;

import java.io.File;
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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tbl_destinos")
@Table(name = "tbl_destinos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Destino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDestino;
    
    @Column(name = "txt_nome_destino")
    private String nomeDestino;
    
    @Column(name = "txt_preco")
    private BigDecimal precoDestino;
    
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "blob_foto_destino", nullable = true)
    private File fotoDestino;
}