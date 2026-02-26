package br.com.bfood.dao;

import br.com.bfood.model.Cliente;
import br.com.bfood.model.ClienteId;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
    private final EntityManager entityManager;

    public ClienteDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente){
        this.entityManager.persist(cliente);
    }

    public ClienteDao consultar(final Integer id){
        return this.entityManager.find(ClienteDao.class, id);
    }

    public void atualizar(Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public void excluir(Cliente cliente){
        this.entityManager.remove(cliente);
    }

    public Cliente consultarPorId(final ClienteId id){
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos(){
        String jpql = "SELECT c FROM Cliente c";
        return entityManager.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> consultarPorNome(final String nome) {
        try{
            String jpql = "SELECT c FROM Cliente c WHERE lower(c.nome) LIKE lower(:nome)";
            return entityManager.createQuery(jpql, Cliente.class).setParameter(
                    "nome", "%" + nome + "%").getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
