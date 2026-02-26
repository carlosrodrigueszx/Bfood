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

    public List<Object[]> consultarItensMaisVendidos(){
        String jpql = "SELECT c.nome, SUM(oc.quantidade) FROM Ordem o " +
                "JOIN OrdensCardapio oc ON o.id = oc.cardapio.id " +
                "JOIN oc.cardapio c " +
                "GROUP BY c.nome " +
                "ORDER BY SUM(oc.quantidade) DESC";
        return entityManager.createQuery(jpql, Object[].class).getResultList();
    }

}
