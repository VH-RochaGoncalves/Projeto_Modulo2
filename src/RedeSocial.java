import Perfis.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedeSocial {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static Scanner entrada = new Scanner (System.in);
    private static String opcao;

    public static void main(String[] args) {
        RedeSocial rede = new RedeSocial();
        System.out.println("Bem-vindo a Rede Social! \n");
        rede.menuInicial();

    }
    private static void menuInicial(){
        do {
            System.out.println("Menu:\n ");
            System.out.println("C - Para cadastrar novo usuário");
            System.out.println("E - Para entrar na Rede Social");
            System.out.println("S - Para sair do sistema.");
            opcao = entrada.nextLine().toUpperCase();
            switch (opcao) {
                case "S" -> System.out.print("Saindo do sistema..");
                case "C" -> cadastrarUsuario();
                case "E" -> entrarNaRedeSocial();
                default -> System.out.println("Nenhuma opção selecionada, por favor digite novamente.");
            }
        } while (!opcao.equals("S"));
    }

    private static void cadastrarUsuario() {

        System.out.println("Digite seu Nome: ");
        String nome = entrada.nextLine().trim();

        System.out.println("Digite o Login: ");
        String login = entrada.nextLine().toUpperCase().trim();

        for (Usuario p : usuarios) {
            if (p.getLogin().equals(login)) {
                System.out.println("Esse usuário já existe! Por favor, escolha outro login..");
                cadastrarUsuario();
            }
        }
        System.out.println("Digite sua senha: ");
        String senha = entrada.nextLine().trim();

        if (nome.isEmpty() || nome.isBlank() || login.isEmpty() || login.isBlank() || senha.isEmpty() || senha.isBlank()) {
            System.out.println("Nenhum campo pode estar em branco, por favor tente de novo!");
            cadastrarUsuario();
        }

        usuarios.add(new Usuario(nome, login, senha));
        System.out.println("Cadastro feito com sucesso! ");
        System.out.println("");
        menuInicial();
    }

    private static void entrarNaRedeSocial() {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum cadastro feito, para logar é preciso criar um cadastro!");
            System.out.println("Vou te levar até lá..");
            cadastrarUsuario();
        } else {
            System.out.println("Digite o seu login para entrar na Rede Social: ");
            String login2 = entrada.nextLine().toUpperCase();

            System.out.println("Agora digite sua senha: ");
            String senha2 = entrada.nextLine();

            for (Usuario p : usuarios) {
                if (login2.equals(p.getLogin()) && senha2.equals(p.getSenha())) {
                    System.out.println("Olá " + p.getNome() + ", bem-vindo A Rede Social!");
                    menuDoUsuario(p);
                }
            }
            System.out.println("Login ou senha inválidos, tente de novo! ");
        }
        menuInicial();
    }

    private static void menuDoUsuario(Usuario usuario) {

        do {
            System.out.println("Menu:\n ");
            System.out.println("P - Para fazer um novo post.");
            System.out.println("T - Para acessar a Timeline.");
            System.out.println("L - Para fazer logout da Rede Social.");
            opcao = entrada.nextLine().toUpperCase();
            switch (opcao) {
                case "P" -> postarNaRede(usuario);
                case "T" -> verTimeLine(usuario);
                case "L" -> System.out.print("Fazendo logout da RedeSocial.. \n");
                default -> System.out.println("Nenhuma opção selecionada, por favor digite novamente.");
            }
        } while (!opcao.equals("L"));
        menuInicial();
    }

    private static void postarNaRede(Usuario usuario) {

        System.out.print("Vamos começar o seu post, digite a data: (formato: dd/mm/aaaa)");
        String data = entrada.nextLine();

        System.out.print("Agora digite o horário deste post: (formato: 00:00)");
        String hora = entrada.nextLine();

        System.out.print("E agora o conteúdo do seu post: ");
        String conteudo = entrada.nextLine();

        if (data.isBlank() ||hora.isBlank() || conteudo.isBlank()) {
            System.out.println("Todos os itens do seu post precisam conter algum caractere!");
            postarNaRede(usuario);
        }

        usuario.postDoUsuario(data, hora, conteudo);
        System.out.println("O post foi realizado na sua Timeline!");
    }

    private static void verTimeLine(Usuario usuario) {
        usuario.imprimirPosts();
    }
}
