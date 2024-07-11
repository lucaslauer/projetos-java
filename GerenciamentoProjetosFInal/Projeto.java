public abstract class Projeto {
    private String nome;
    private String nivel;
    private double custo;
    private Gerente gerente; // Adiciona a associação com a classe Gerente

    public Projeto(String nome, String nivel, double custo, Gerente gerente) {
        this.nome = nome;
        this.nivel = nivel;
        this.custo = custo;
        this.gerente = gerente; // Inicializa a associação com a classe Gerente
        this.gerente.addProjeto(this); // Adiciona este projeto à lista de projetos do gerente
    }

    public String getNome() {
        return nome;
    }

    public String getNivel() {
        return nivel;
    }

    public double getCusto() {
        return custo;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public abstract String getTipo();

    public abstract String getDetalhes();
}