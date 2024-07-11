public class ProjetoAplicativo extends Projeto {
    private final String plataforma;
    private final double tamanho;

    public ProjetoAplicativo(String nome, String nivel, double custo, Gerente gerente, String plataforma, double tamanho) {
        super(nome, nivel, custo, gerente);
        this.plataforma = plataforma;
        this.tamanho = tamanho;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getTamanho() {
        return tamanho;
    }

    public String getTipo() {
        return "Aplicativo";
    }

    public String getDetalhes() {
        return String.format("Plataforma: " + getPlataforma() + " Tamanho: " + getTamanho() + "kB");
    }
}