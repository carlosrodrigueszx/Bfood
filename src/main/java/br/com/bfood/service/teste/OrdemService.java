package br.com.bfood.service.teste;

import br.com.bfood.dao.CardapioDao;
import br.com.bfood.dao.ClienteDao;
import br.com.bfood.dao.OrdemDao;
import br.com.bfood.model.Cliente;
import br.com.bfood.model.Ordem;
import br.com.bfood.model.OrdensCardapio;
import br.com.bfood.utils.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerBFood();
        entityManager.getTransaction().begin();

        CargaDeDados.cadastrarCategorias(entityManager);
        CargaDeDados.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Cliente felipe = new Cliente("11122233345", "Felipe", "10102334");
        Ordem ordem = new Ordem(felipe);

        ordem.addOrdensCardapio(new OrdensCardapio(ordem, cardapioDao.consultarPorId(1), 2));
        clienteDao.cadastrar(felipe);
        ordemDao.cadastrar(ordem);

        System.out.println(ordemDao.consultarTodos());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
