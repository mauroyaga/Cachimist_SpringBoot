package br.senac.parana.calchimistapp.controlador;

import br.senac.parana.calchimistapp.entidades.Componente;
import br.senac.parana.calchimistapp.repositorio.ComponenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController   //Anotação que define para o sping que esté é uma classe de controle de uma API rest
@RequestMapping("/componentes")     //Anotação específica a(end-point)URL que um método do controlador irá manipular.
public class ComponenteControlador {

    private final ComponenteRepositorio componenteRepositorio;

    @Autowired   //Anotação que permite obter a instância de uma classe sem criar manualmente
    public ComponenteControlador(ComponenteRepositorio componenteRepositorio) {
        this.componenteRepositorio = componenteRepositorio;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Componente> obterComponentePorId(@PathVariable Long id) {
        Optional<Componente> componente = componenteRepositorio.findById(id);
        return componente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Componente>> obterComponentesPorNome(@PathVariable String nome) {
        List<Componente> componentes = componenteRepositorio.findByNomeComponenteContaining(nome);
        return ResponseEntity.ok(componentes);
    }

    @PostMapping
    public ResponseEntity<Componente> criarComponente(@RequestBody Componente componente) {
        Componente componenteCriado = componenteRepositorio.save(componente);
        return ResponseEntity.status(HttpStatus.CREATED).body(componenteCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirComponentePorId(@PathVariable Long id) {
        if (!componenteRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        componenteRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
