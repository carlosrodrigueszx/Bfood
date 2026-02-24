package br.com.bfood.dao;

import br.com.bfood.model.Categoria;
import br.com.bfood.model.Endereco;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {
    private final EntityManager entityManager;

    public EnderecoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Endereco endereco){
        this.entityManager.persist(endereco);
    }

    public Endereco consultar(final Integer id){
        return this.entityManager.find(Endereco.class, id);
    }

    public void atualizar(Endereco endereco){
        this.entityManager.merge(endereco);
    }

    public void excluir(Endereco endereco){
        this.entityManager.remove(endereco);
    }

    public List<Endereco> consultarTodos(){
        String jpql = "SELECT e FROM Endereco e";
        return entityManager.createQuery(jpql, Endereco.class).getResultList();
    }

}
