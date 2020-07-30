package com.ithappens.estoque.repository;

import com.ithappens.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Produto findById(long id);

    @Query("select prd from Produto prd where trim(upper(prd.cdgBarras)) =: cdgBarras ")
    Optional<Produto> findByCdgBarras(String cdgBarras);

    @Query("select prd from Produto prd where trim(upper(prd.descricao))=:descricao")
    Optional<Produto>findByDescricao(String descricao);
}