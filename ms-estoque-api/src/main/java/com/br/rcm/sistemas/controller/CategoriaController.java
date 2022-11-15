package com.br.rcm.sistemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.rcm.sistemas.dto.CategoriaDto;
import com.br.rcm.sistemas.model.Categoria;
import com.br.rcm.sistemas.service.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
    private CategoriaService categoriaService;

	@GetMapping(value = "/")
	public String ola() {
		return "Seja bem-vindo!!!";
	}
	
    @GetMapping
    public ResponseEntity<List<Categoria>> listaCategoria(){
        List<Categoria> lista = categoriaService.listaCategoria();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/CategoriaAtivoProduto")
    public ResponseEntity<List<Categoria>> listaCategoriaAtivaComProduto(){
        List<Categoria> lista = categoriaService.listaCategoriaAtivaComProduto();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/CategoriasAtivas")
    public ResponseEntity<List<Categoria>> listaCategoriasAtivas(){
        List<Categoria> lista = categoriaService.listaCategoriasAtivas();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/CategoriasInativas")
    public ResponseEntity<List<Categoria>> listaCategoriasInativas(){
        List<Categoria> lista = categoriaService.listaCategoriasInativas();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> salvarCategoria(@RequestBody CategoriaDto categoriaDto) {
    	Categoria categoria = categoriaService.cadastrar(categoriaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDto);
    }
}
