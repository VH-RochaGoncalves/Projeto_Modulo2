public class Posts {
    protected String data;
    protected String hora;
    protected String conteudo;

    public Posts(String data, String hora, String conteudo){
        this.data = data;
        this.hora = hora;
        this.conteudo = conteudo;
    }

    void imprimir(){
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora );
        System.out.println("\n" + conteudo);
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
