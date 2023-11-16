package br.senac.parana.calchimistapp.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "componente")
public class Componente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_componente", nullable = false, length = 50, unique = true)
    private String nomeComponente;

    @Column(name = "descricao_componente", nullable = false, length = 1000)
    private String descricaoComponente;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;

    @Column(name = "fornecedor", nullable = false, length = 50)
    private String fornecedor;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public String getDescricaoComponente() {
        return descricaoComponente;
    }

    public void setDescricaoComponente(String descricaoComponente) {
        this.descricaoComponente = descricaoComponente;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
