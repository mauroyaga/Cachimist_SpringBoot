package br.senac.parana.calchimistapp.controlador;

import br.senac.parana.calchimistapp.entidades.Usuario;
import br.senac.parana.calchimistapp.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioControlador(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Usuario> obterUsuarioPorNome(@PathVariable String nome) {
        Optional<Usuario> usuario = usuarioRepositorio.findByNomeUsuario(nome);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCriado = usuarioRepositorio.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        if (!usuarioRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioAtualizado.setId(id);
        Usuario usuarioAtualizadoSalvo = usuarioRepositorio.save(usuarioAtualizado);
        return ResponseEntity.ok(usuarioAtualizadoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        if (!usuarioRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
