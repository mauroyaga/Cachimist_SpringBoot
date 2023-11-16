package br.senac.parana.calchimistapp.repositorio;

import br.senac.parana.calchimistapp.entidades.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormulaRepositorio extends JpaRepository<Formula, Long> {
    List<Formula> findByNomeFormulaContaining(String nome);

    Optional<Formula> findById(Long id);
}
