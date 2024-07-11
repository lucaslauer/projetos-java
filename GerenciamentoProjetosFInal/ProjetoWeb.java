public class ProjetoWeb extends Projeto {
    private String linguagem;
    private String bd;

    public ProjetoWeb(String nome, String nivel, double custo, Gerente gerente, String linguagem, String bd) {
        super(nome, nivel, custo, gerente);
        this.linguagem = linguagem;
        this.bd = bd;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public String getBd() {
        return bd;
    }

    public String getTipo() {
        return "Web";
    }

    public String getDetalhes() {
        return String.format(" Linguagem: " + getLinguagem() + " Banco de Dados: " + getBd());
    }
}