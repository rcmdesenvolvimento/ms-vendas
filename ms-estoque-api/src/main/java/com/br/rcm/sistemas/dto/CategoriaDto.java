package com.br.rcm.sistemas.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDto {

    @NotBlank(message = "Informe o código da categoria")
    private String codCategoria;

    @NotBlank(message = "Informe a descrição da categoria")
    private String descricao;

    private boolean ativo;

}
