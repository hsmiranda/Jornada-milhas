package org.estudos.jornadamilhas.destino;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.File;
import java.math.BigDecimal;

@Entity(name = "tbl_destinos")
@Table(name = "tbl_destinos")
@Data
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
    @Column(name = "blob_foto1_destino", nullable = true)
    private File foto1Destino;

    @Lob
    @Basic(fetch =  FetchType.EAGER)
    @Column(name = "blob_foto2_destino", nullable = true)
    private File foto2Destino;

    @Column(name = "txt_meta_destino")
    @Size(max = 160, message = "Meta has between 0 and 160 characters")
    private String metaDestino;

    @Column(name = "txt_descricao_destino", nullable = true, length = 1024)
    private String textoDescritivoDestino;
}