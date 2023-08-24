package org.estudos.jornadamilhas.depoimentos;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "tbl_depoimento")
@Table(name = "tbl_depoimento")
@Data
public class Depoimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "txt_nome")
    private String nomePessoa;

    @Column(name = "txt_depoimento")
    private String textoDepoimento;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(nullable = true, name = "blob_foto")
    private byte[] foto;

}
