package br.com.bfood.dao;

import br.com.bfood.model.Categoria;
import br.com.bfood.model.Endereco;
import br.com.bfood.vo.ClienteVo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.ObjectStreamException;
import java.util.List;
import java.util.Objects;

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

    public List<ClienteVo> consultarClientes(final String estado, final String cidade, final String rua){
        String jpql = "SELECT new br.com.bfood.vo.ClienteVo(e.cliente.cpf, e.cliente.nome) " +
                "FROM Endereco e WHERE 1=1 ";

        if (Objects.nonNull(estado)){
            jpql = jpql.concat("AND UPPER(e.estado) = UPPER(:estado) ");
        }

        if (Objects.nonNull(cidade)){
            jpql = jpql.concat("AND UPPER(e.cidade) = UPPER(:cidade) ");
        }

        if (Objects.nonNull(rua)){
            jpql = jpql.concat("AND UPPER(e.rua) = UPPER(:rua) ");
        }

        TypedQuery typedQuery = entityManager.createQuery(jpql, ClienteVo.class);

        if (Objects.nonNull(estado)){
            typedQuery.setParameter("estado", estado);
        }

        if (Objects.nonNull(cidade)){
            typedQuery.setParameter("cidade", cidade);
        }

        if (Objects.nonNull(rua)){
            typedQuery.setParameter("rua", rua);
        }

        return typedQuery.getResultList();
    }

}
