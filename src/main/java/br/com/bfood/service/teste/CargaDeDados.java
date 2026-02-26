package br.com.bfood.service.teste;

import br.com.bfood.dao.CardapioDao;
import br.com.bfood.dao.CategoriaDao;
import br.com.bfood.dao.ClienteDao;
import br.com.bfood.dao.OrdemDao;
import br.com.bfood.model.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public class CargaDeDados {
    private CargaDeDados(){}

    public static void cadastrarCategorias(EntityManager entityManager) {
        Categoria entrada = new Categoria("Entradas");
        Categoria salada = new Categoria("Saladas");
        Categoria principal = new Categoria("Principal");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(entrada);
        entityManager.flush();

        categoriaDao.cadastrar(salada);
        entityManager.flush();

        categoriaDao.cadastrar(principal);
        entityManager.flush();

        entityManager.clear();
    }

    public static void cadastrarProdutosCardapio(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();

        Cardapio moqueca = new Cardapio(
                "Moqueca",
                "Peixe com banana da terra e farofa",
                true,
                BigDecimal.valueOf(100),
                categorias.get(1)
        );

        Cardapio bife = new Cardapio(
                "Bife acebolado",
                "Bife bem passado com cebola",
                true,
                BigDecimal.valueOf(40),
                categorias.get(1)
        );

        Cardapio saladaDoce = new Cardapio(
                "Salada de frutas doces",
                "Salada com pedaços de manga, abacaxi, maçã, repolho e alface",
                true,
                BigDecimal.valueOf(30),
                categorias.get(2)
        );

        cardapioDao.cadastrar(moqueca);
        cardapioDao.cadastrar(bife);
        cardapioDao.cadastrar(saladaDoce);

        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarClientes(EntityManager entityManager){
        ClienteDao clienteDao = new ClienteDao(entityManager);
        Cliente rodolfo = new Cliente("12344466678", "Rodolfo");
        Cliente felipe = new Cliente("11122233345", "Felipe");
        Cliente maria = new Cliente("29003182273", "Maria");
        rodolfo.addEndereco(new Endereco("Vizinho ao banco Caixa", "63630100", "Pedra Branca",
                "CE", "Rua dois", 155));

        felipe.addEndereco(new Endereco("Do lado da loja de informática", "03032001", "Abacaxinópoles",
                "SP", "Rua um", 157));

        maria.addEndereco(new Endereco("Casa no fim da rua", "19192001", "Pintoanápoles", "MG", "Rua três", 780));
        clienteDao.cadastrar(rodolfo);
        clienteDao.cadastrar(felipe);
        clienteDao.cadastrar(maria);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarOrdensClientes(EntityManager entityManager){
        OrdemDao ordemDao = new OrdemDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        Ordem ordem1 = new Ordem(clienteDao.consultarTodos().get(0));
        Ordem ordem2 = new Ordem(clienteDao.consultarTodos().get(1));
        Ordem ordem3 = new Ordem(clienteDao.consultarTodos().get(2));
        Ordem ordem4 = new Ordem(clienteDao.consultarTodos().get(1));

        ordem1.addOrdensCardapio(new OrdensCardapio(ordem1, cardapioDao.consultarTodos().get(0), 5));
        ordem2.addOrdensCardapio(new OrdensCardapio(ordem2, cardapioDao.consultarTodos().get(1), 4));
        ordem3.addOrdensCardapio(new OrdensCardapio(ordem3, cardapioDao.consultarTodos().get(2), 5));
        ordem4.addOrdensCardapio(new OrdensCardapio(ordem4, cardapioDao.consultarTodos().get(1), 7));

        ordemDao.cadastrar(ordem1);
        ordemDao.cadastrar(ordem2);
        ordemDao.cadastrar(ordem3);
        ordemDao.cadastrar(ordem4);

        entityManager.flush();
        entityManager.clear();
    }
}
