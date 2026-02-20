package br.com.bfood.dao;

import br.com.bfood.model.Categoria;
import br.com.bfood.model.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public Categoria consultar(final Integer id){
        return this.entityManager.find(Categoria.class, id);
    }

    public void atualizar(Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(Categoria categoria){
        this.entityManager.remove(categoria);
    }

    public List<Categoria> consultarTodos(){
        String jpql = "SELECT c FROM Categoria c";
        return entityManager.createQuery(jpql, Categoria.class).getResultList();
    }

}
