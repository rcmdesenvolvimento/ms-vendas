package com.br.rcm.sistemas.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.rcm.sistemas.dto.CategoriaDto;
import com.br.rcm.sistemas.model.Categoria;
import com.br.rcm.sistemas.repository.CategoriaRepository;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;
    private ModelMapper mapper;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
        this.mapper = new ModelMapper();
    }

    @Transactional
    public Categoria cadastrar(CategoriaDto categoriaDto) {
        try {
            Categoria categoria = this.mapper.map(categoriaDto, Categoria.class);
            return categoriaRepository.save(categoria);
        } catch (Exception e) {
            throw new NullPointerException("Erro ao gravar Categoria");
        }
    }

    public List<Categoria> listaCategoria(){
        log.info("Entrei no SERVICE para listar categoria");
        List<Categoria> lista = categoriaRepository.findAll();
        return lista;
    }

    public List<Categoria> listaCategoriaAtivaComProduto(){
        return categoriaRepository.findDistinctByprodutoIsNotNull();
    }

    public List<Categoria> listaCategoriasAtivas(){
        return categoriaRepository.findByAtivoTrue();
    }

    public List<Categoria> listaCategoriasInativas(){
        return categoriaRepository.findByAtivoFalse();
    }
}
