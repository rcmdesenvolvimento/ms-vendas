package com.br.rcm.sistemas.repository;

import com.br.rcm.sistemas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByAtivoTrue();

    List<Categoria> findByAtivoFalse();

    List<Categoria> findDistinctByprodutoIsNotNull();

//    @Query(value = "SELECT DISTINCT c.* FROM Categoria c JOIN Produto p ON c.id = p.categoria_id " +
//            "WHERE c.ativo_categoria = 1 and p.categoria_id is not null", nativeQuery = true)
//    List<Categoria> listaCategoriaAtivaComProduto();
}
