package br.com.bfood.dao;

import br.com.bfood.model.Cardapio;
import br.com.bfood.model.Cliente;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
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

    public List<Cliente> consultarTodos(){
        String jpql = "SELECT c FROM Cliente c";
        return entityManager.createQuery(jpql, Cliente.class).getResultList();
    }


    public Cliente consultarPorNome(final String filtro) {
        try {
            String jpql = "SELECT c FROM Cliente c WHERE upper(c.nome) = upper(:nome)";
            return entityManager.createQuery(jpql, Cliente.class).setParameter("nome", filtro).getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }
}
