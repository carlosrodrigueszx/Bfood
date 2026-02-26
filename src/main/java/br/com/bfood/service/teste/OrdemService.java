package br.com.bfood.service.teste;

import br.com.bfood.dao.CardapioDao;
import br.com.bfood.dao.ClienteDao;
import br.com.bfood.dao.OrdemDao;
import br.com.bfood.model.Cliente;
import br.com.bfood.model.Endereco;
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
        CargaDeDados.cadastrarClientes(entityManager);
        CargaDeDados.cadastrarOrdensClientes(entityManager);

        ClienteDao clienteDao = new ClienteDao(entityManager);

        System.out.println(clienteDao.consultarPorNome("Rod"));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
