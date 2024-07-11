import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Projeto> projetos = new ArrayList<>();
    private static List<Gerente> gerentes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("[GERENCIAMENTO DE PROJETOS]");
            System.out.println("1 - Incluir um projeto");
            System.out.println("2 - Pesquisar um projeto");
            System.out.println("3 - Remover um projeto");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção (Digite o número): ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    incluirProjeto();
                    break;
                case 2:
                    pesquisarProjeto();
                    break;
                case 3:
                    removerProjeto();
                    break;
                case 4:
                    System.out.println("Total de projetos: " + projetos.size());
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção Inexistente.");
            }
        } while (opcao != 4);
    }

    private static void incluirProjeto() {
        System.out.print("Digite o nome do gerente de projetos: ");
        String nomeGerente = scanner.nextLine();

        Gerente gerente = null;
        for (Gerente g : gerentes) {
            if (g.getNome().equalsIgnoreCase(nomeGerente)) {
                gerente = g;
                break;
            }
        }
        if (gerente == null) {
            gerente = new Gerente(nomeGerente);
            gerentes.add(gerente);
        }
        String nome;
        boolean nomeDuplicado;
        do {
            System.out.print("Digite o nome do projeto: ");
            nome = scanner.nextLine();
            nomeDuplicado = false;
            for (Projeto p : projetos) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    nomeDuplicado = true;
                    System.out.println("Já existe um projeto com esse nome. Por favor, insira um nome diferente.");
                    break;
                }
            }
        } while (nomeDuplicado);
        System.out.println("Escolha o nível do projeto (Digite o número):");
        System.out.println("1 - Operacional");
        System.out.println("2 - Estratégico");
        int opcaoNivel;
        String nivelProjeto;
        while (true) {
            opcaoNivel = scanner.nextInt();
            if (opcaoNivel == 1) {
                nivelProjeto = "Operacional";
                break;
            } else if (opcaoNivel == 2) {
                nivelProjeto = "Estratégico";
                break;
            } else {
                System.out.println("Opção inválida. Insira um número válido (1-Operacional ou 2-Estratégico).");
            }
        }

        double custo;
        do {
            System.out.print("Digite o custo do projeto: ");
            custo = scanner.nextDouble();
            if (custo <= 0) {
                System.out.println("O custo deve ser maior que zero.");
            }
        } while (custo <= 0);
        scanner.nextLine();

        System.out.print("O projeto é Web ou Aplicativo? ");
        String tipo = scanner.nextLine();
        Projeto projeto = null;
        if (tipo.equalsIgnoreCase("Web")) {
            System.out.print("Digite a linguagem usada: ");
            String linguagem = scanner.nextLine();
            System.out.print("Digite o banco de dados usado: ");
            String bancoDeDados = scanner.nextLine();
            projeto = new ProjetoWeb(nome, nivelProjeto, custo, gerente, linguagem, bancoDeDados);
        } else if (tipo.equalsIgnoreCase("Aplicativo")) {

            System.out.print("Digite a plataforma (Android ou iOS): ");
            String plataforma = scanner.nextLine();

            double tamanho;
            do {
                System.out.print("Digite o tamanho do projeto (em kB): ");
                tamanho = scanner.nextDouble();
                if (tamanho <= 0) {
                    System.out.println("O tamanho deve ser maior que zero.");
                }
            } while (tamanho <= 0);
            scanner.nextLine();

            projeto = new ProjetoAplicativo(nome, nivelProjeto, custo, gerente, plataforma, tamanho);
        } else {
            System.out.println("Tipo de projeto inválido.");
            return;
        }
        projetos.add(projeto);
        gerente.addProjeto(projeto);
        System.out.println("Projeto incluído com sucesso.");
    }

    private static void pesquisarProjeto() {
        System.out.print("Digite o nome do projeto a pesquisar: ");
        String nomeProjeto = scanner.nextLine();
        for (Projeto projeto : projetos) {
            if (projeto.getNome().equalsIgnoreCase(nomeProjeto)) {
                System.out.println("Projeto encontrado...");
                System.out.println("Projeto: " + projeto.getNome() + " - " + projeto.getNivel());
                System.out.println("Custo: " + projeto.getCusto());
                System.out.println("Tipo: " + projeto.getTipo());
                System.out.println("Detalhes: " + projeto.getDetalhes());
                System.out.println("Gerente: " + projeto.getGerente().getNome());
                return;
            }
        }
        System.out.println("Projeto não encontrado.");
    }

    private static void removerProjeto() {
        System.out.print("Digite o nome do projeto a remover: ");
        String nomeProjeto = scanner.nextLine();
        for (int i = 0; i < projetos.size(); i++) {
            if (projetos.get(i).getNome().equalsIgnoreCase(nomeProjeto)) {
                Projeto projeto = projetos.remove(i);
                for (Gerente gerente : gerentes) {
                    if (gerente.getNome().equalsIgnoreCase(projeto.getGerente().getNome())) {
                        gerente.getProjetos().remove(projeto);
                        break;
                    }
                }
                System.out.println("Projeto removido com sucesso.");
                return;
            }
        }
        System.out.println("Projeto não encontrado.");
    }
}