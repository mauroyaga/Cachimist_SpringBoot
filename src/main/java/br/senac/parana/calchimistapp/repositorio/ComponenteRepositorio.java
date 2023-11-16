package br.senac.parana.calchimistapp.repositorio;

import br.senac.parana.calchimistapp.entidades.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ComponenteRepositorio extends JpaRepository<Componente, Long> {
    List<Componente> findByNomeComponenteContaining(String nome);

    Optional<Componente> findById(Long id);
}
