import java.util.ArrayList;
import java.util.List;

public class Usuario {
    protected String nome;
    protected String login;
    protected String senha;
    List<Posts> posts = new ArrayList<>();

    public Usuario (String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    protected List<Posts> postDoUsuario(String data, String hora, String conteudo){
        Posts p = new Posts(data, hora, conteudo);
        data = p.getData();
        hora = p.getHora();
        conteudo = p.getConteudo();
        posts.add(new Posts(data, hora, conteudo));
        return posts;
    }

    protected void imprimirPosts(){
        System.out.println("-- TimeLine: -- \n");
        System.out.println("Nome: " + nome);
        for (Posts post : posts){
            post.imprimir();
            System.out.println("\n ----------------------------------- \n");
        }
    }
}
