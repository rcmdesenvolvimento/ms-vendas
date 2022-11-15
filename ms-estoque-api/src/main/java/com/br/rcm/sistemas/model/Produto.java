package com.br.rcm.sistemas.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_produto", length = 20, unique = true)
    private String codProduto;

    @Column(name = "descricao_produto", length = 100, unique = true)
    private String descricao;
}
