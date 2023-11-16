package br.senac.parana.calchimistapp.telas;

import br.senac.parana.calchimistapp.controlador.UsuarioControlador;
import br.senac.parana.calchimistapp.entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component; // Adicionado para indicar que esta classe é um componente Spring

import java.util.List;
import java.util.Scanner;

@Component
public class UsuarioTela {
    private static UsuarioControlador usuarioControlador = null;

    public UsuarioTela(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Listar Usuários");
            System.out.println("2. Criar Usuário");
            System.out.println("3. Atualizar Usuário");
            System.out.println("4. Excluir Usuário");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarUsuarios();
                    break;
                case 2:
                    criarUsuario();
                    break;
                case 3:
                    atualizarUsuario();
                    break;
                case 4:
                    excluirUsuario();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void listarUsuarios() {
        List<Usuario> usuarios = (List<Usuario>) usuarioControlador.listarUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNomeUsuario());
            // Exibir outras informações do usuário, se necessário
        }
    }

    private static void criarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nome);

        usuarioControlador.criarUsuario(usuario);
        System.out.println("Usuário criado com sucesso.");
    }

    private static void atualizarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do usuário a ser atualizado: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir quebra de linha

        ResponseEntity<Usuario> usuarioExistente = usuarioControlador.obterUsuarioPorId(id);
        if (usuarioExistente.getBody() == null) { // Verificar o corpo da resposta, que contém o usuário
            System.out.println("Usuário não encontrado.");
            return;
        }

        Usuario usuarioAtualizado = usuarioExistente.getBody();

        System.out.print("Novo nome do usuário: ");
        String novoNome = scanner.nextLine();
        usuarioAtualizado.setNomeUsuario(novoNome);

        usuarioControlador.atualizarUsuario(id, usuarioAtualizado);
        System.out.println("Usuário atualizado com sucesso.");
    }

    private static void excluirUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do usuário a ser excluído: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir quebra de linha

        ResponseEntity<Usuario> usuarioExistente = usuarioControlador.obterUsuarioPorId(id);
        if (usuarioExistente.getBody() == null) { // Verificar o corpo da resposta, que contém o usuário
            System.out.println("Usuário não encontrado.");
            return;
        }

        usuarioControlador.excluirUsuario(id);
        System.out.println("Usuário excluído com sucesso.");
    }
}
