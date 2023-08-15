package org.estudos.jornadamilhas.domain;

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

@Entity(name = "tbl_depoimento")
@Table(name = "tbl_depoimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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
