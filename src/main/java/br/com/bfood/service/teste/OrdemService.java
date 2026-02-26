package br.com.bfood.service.teste;

import br.com.bfood.dao.ClienteDao;
import br.com.bfood.dao.EnderecoDao;
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

        EnderecoDao enderecoDao = new EnderecoDao(entityManager);

        System.out.println(enderecoDao.consultarClientes(null, null, "Rua dois"));
        System.out.println(enderecoDao.consultarClientesComCriteria(null, null, "Rua dois"));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
