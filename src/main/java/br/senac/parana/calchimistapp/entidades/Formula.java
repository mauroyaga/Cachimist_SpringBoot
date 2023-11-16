package br.senac.parana.calchimistapp.entidades;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "formula")
public class Formula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formula")
    private Long id;

    @Column(name = "nome_formula", nullable = false, length = 40)
    private String nomeFormula;

    @Column(name = "descricao_formula", nullable = false, length = 1000)
    private String descricaoFormula;

    @Column(name = "data_criacao", nullable = false)
    @Temporal(TemporalType.DATE) // Mapeia a coluna de data
    private Date dataCriacao;

    // Relacionamento: Uma fórmula pertence a um usuário
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeformula() {
        return nomeFormula;
    }

    public void setNomeFormula(String nome_formula) {
        this.nomeFormula = nome_formula;
    }

    public String getDescricaoFormula() {
        return descricaoFormula;
    }

    public void setDescricaoFormula(String descricao_formula) {
        this.descricaoFormula = descricao_formula;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date data_criacao) {
        this.dataCriacao = data_criacao;
    }

}
