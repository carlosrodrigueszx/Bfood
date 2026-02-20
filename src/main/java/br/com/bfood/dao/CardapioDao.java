package br.com.bfood.dao;

import br.com.bfood.model.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioDao {

    private final EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println("Entidade cadastrada: " + cardapio);
    }

    public Cardapio consultarPorId(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }

    public List<Cardapio> consultarTodos(){
        String jpql = "SELECT c FROM Cardapio c";
        return entityManager.createQuery(jpql, Cardapio.class).getResultList();
    }

    public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
        return entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", filtro).getResultList();
    }

    public Cardapio consultarPorNome(final String filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE upper(c.nome) = upper(:nome)";
            return entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", filtro).getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }
}
