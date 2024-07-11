import java.util.ArrayList;
import java.util.List;

public class Gerente {
    private String nome;
    private List<Projeto> projetos; // Adiciona a associação com a classe Projeto

    public Gerente(String nome) {
        this.nome = nome;
        this.projetos = new ArrayList<>(); // Inicializa a associação com a classe Projeto
    }

    public String getNome() {
        return nome;
    }

    public void addProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }
}