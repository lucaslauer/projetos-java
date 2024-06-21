import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Projeto atribuído em código
        Gerente gerente1 = new Gerente("Gerente 1");
        Projeto projeto1 = new Projeto("Projeto 1", "Operacional", 1000.0, gerente1);

        // Projeto informado pelo usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do gerente:");
        String nomeGerente = scanner.nextLine();
        Gerente gerente2 = new Gerente(nomeGerente);
        System.out.println("Insira o nome do projeto:");
        String nomeProjeto = scanner.nextLine();
        System.out.println("Escolha o nível do projeto:");
        System.out.println("1 - Operacional");
        System.out.println("2 - Estratégico");
        int opcaoNivel = scanner.nextInt();
        String nivelProjeto;
        if (opcaoNivel == 1) {
            nivelProjeto = "Operacional";
        } else if (opcaoNivel == 2) {
            nivelProjeto = "Estratégico";
        } else {
            System.out.println("Opção inválida. Usando nível padrão: Operacional.");
            nivelProjeto = "Operacional";
        }
        double custoProjeto = 0;
        do {
            System.out.println("Insira o custo do projeto:");
            custoProjeto = scanner.nextDouble();
            if (custoProjeto <= 0) {
                System.out.println("O custo deve ser maior que zero. Insira um valor válido.");
            }
        } while (custoProjeto <= 0);
        Projeto projeto2 = new Projeto(nomeProjeto, nivelProjeto, custoProjeto, gerente2);
         
        exibirProjeto(projeto1);
        System.out.println();
        exibirProjeto(projeto2);
    }

    public static void exibirProjeto(Projeto projeto) {
        System.out.println("Projeto: " + projeto.getNome() + " - " + projeto.getNivel());
        System.out.println("Custo: " + projeto.getCusto());
        System.out.println("Gerente de Projetos: " + projeto.getGerente().getNome());
        System.out.println();
    }
}