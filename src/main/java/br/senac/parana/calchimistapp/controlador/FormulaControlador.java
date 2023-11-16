package br.senac.parana.calchimistapp.controlador;

import br.senac.parana.calchimistapp.entidades.Formula;
import br.senac.parana.calchimistapp.repositorio.FormulaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formulas")
public class FormulaControlador {

    private final FormulaRepositorio formulaRepositorio;

    @Autowired
    public FormulaControlador(FormulaRepositorio formulaRepositorio) {
        this.formulaRepositorio = formulaRepositorio;
    }

    @GetMapping
    public ResponseEntity<List<Formula>> listarFormulas() {
        List<Formula> formulas = formulaRepositorio.findAll();
        return ResponseEntity.ok(formulas);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Formula> obterFormulaPorId(@PathVariable Long id) {
        Optional<Formula> formula = formulaRepositorio.findById(id);
        return formula.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Formula>> obterFormulasPorNome(@PathVariable String nome) {
        List<Formula> formulas = formulaRepositorio.findByNomeFormulaContaining(nome);
        return ResponseEntity.ok(formulas);
    }

    @PostMapping
    public ResponseEntity<Formula> criarFormula(@RequestBody Formula formula) {
        Formula formulaCriada = formulaRepositorio.save(formula);
        return ResponseEntity.status(HttpStatus.CREATED).body(formulaCriada);
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> excluirFormulaPorId(@PathVariable Long id) {
        if (formulaRepositorio.existsById(id)) {
            formulaRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
