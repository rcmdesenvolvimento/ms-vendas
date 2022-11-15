package com.br.rcm.sistemas.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_categoria", nullable = false, length = 20)
    private String codCategoria;

    @Column(name = "descricao_categoria", nullable = false, length = 100)
    private String descricao;

    @Column(name = "ativo_categoria", nullable = false)
    private boolean ativo = false;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private List<Produto> produto = new ArrayList<>();

}
