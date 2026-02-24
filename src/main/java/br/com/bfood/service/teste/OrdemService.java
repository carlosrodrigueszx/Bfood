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

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endFelipe = new Endereco("Do lado da loja de informática", "03032001", "Abacaxinópoles",
                "SP", "Rua um", 157);
        Cliente felipe = new Cliente("11122233345", "Felipe");
        felipe.addEndereco(endFelipe);
        Ordem ordem = new Ordem(felipe);
        ordem.addOrdensCardapio(new OrdensCardapio(ordem, cardapioDao.consultarPorId(1), 2));
        clienteDao.cadastrar(felipe);
        ordemDao.cadastrar(ordem);

        System.out.println(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
