package br.senac.parana.calchimistapp.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_usuario")
        private Long id;

        @Column(name = "login", nullable = false, length = 30)
        private String login;

        @Column(name = "senha", nullable = false, length = 50)
        private String senha;

        @Column(name = "tipo_usuario", nullable = false, length = 30)
        private String tipoUsuario;

        @Column(name = "nome_usuario", nullable = false, length = 50)
        private String nomeUsuario;

        @Column(name = "email", nullable = false, length = 50)
        private String email;

        @OneToMany(mappedBy = "usuario")
        private List<Formula> formulas;

        // Getters and Setters
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getLogin() {
                return login;
        }

        public void setLogin(String login) {
                this.login = login;
        }

        public String getSenha() {
                return senha;
        }

        public void setSenha(String senha) {
                this.senha = senha;
        }

        public String getTipoUsuario() {
                return tipoUsuario;
        }

        public void setTipoUsuario(String tipoUsuario) {
                this.tipoUsuario = tipoUsuario;
        }

        public String getNomeUsuario() {
                return nomeUsuario;
        }

        public void setNomeUsuario(String nomeUsuario) {
                this.nomeUsuario = nomeUsuario;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public List<Formula> getFormulas() {
                return formulas;
        }

        public void setFormulas(List<Formula> formulas) {
                this.formulas = formulas;
        }
}
