package br.com.bfood.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDecriacao = LocalDateTime.now();

    @ManyToOne
    private Cliente cliente;

    public List<OrdensCardapio> getOrdensCardapioList() {
        return ordensCardapioList;
    }

    public void setOrdensCardapioList(List<OrdensCardapio> ordensCardapioList) {
        this.ordensCardapioList = ordensCardapioList;
    }

    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
    private List<OrdensCardapio> ordensCardapioList = new ArrayList<>();

    public Ordem(){}

    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addOrdensCardapio(OrdensCardapio ordensCardapio){
        ordensCardapio.setOrdem(this);
        this.ordensCardapioList.add(ordensCardapio);
        BigDecimal qtd = BigDecimal.valueOf(ordensCardapio.getQuantidade());
        BigDecimal valor_parcial = ordensCardapio.getValorDeRegistro();
        this.valorTotal = qtd.multiply(valor_parcial);
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataDecriacao() {
        return dataDecriacao;
    }

    public void setDataDecriacao(LocalDateTime dataDecriacao) {
        this.dataDecriacao = dataDecriacao;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataDecriacao=" + dataDecriacao +
                ", cliente=" + cliente +
                ", ordensCarpio=" + ordensCardapioList +
                '}';
    }
}
