package br.com.bfood.dao;

import br.com.bfood.model.Ordem;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {
    private final EntityManager entityManager;

    public OrdemDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Ordem ordem){
        this.entityManager.persist(ordem);
    }

    public Ordem consultar(final Integer id){
        return this.entityManager.find(Ordem.class, id);
    }

    public void atualizar(Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void excluir(Ordem ordem){
        this.entityManager.remove(ordem);
    }

    public List<Ordem> consultarTodos(){
        String jpql = "SELECT o FROM Ordem o";
        return entityManager.createQuery(jpql, Ordem.class).getResultList();
    }

}
