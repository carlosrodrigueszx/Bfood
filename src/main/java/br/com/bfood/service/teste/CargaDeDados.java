package br.com.bfood.service.teste;

import br.com.bfood.dao.CardapioDao;
import br.com.bfood.dao.CategoriaDao;
import br.com.bfood.model.Cardapio;
import br.com.bfood.model.Categoria;

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
}
