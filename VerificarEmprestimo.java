import java.util.Scanner;

public class VerificarEmprestimo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double parcelaMensal, salario, percentualSalario;
        String simular;

        do {
            System.out.println("Simulação Bancária de Modalidades de Empréstimo");
            System.out.println("Digite o valor da parcela mensal pretendida:");
            parcelaMensal = teclado.nextDouble();
            System.out.println("Digite o valor do salário do cliente:");
            salario = teclado.nextDouble();

            if (parcelaMensal <= 0 || salario <= 0) {
                System.out.println("Erro: Os valores de parcela e salário devem ser maiores que zero!");
                System.out.println("-----------------------------------------------------------------");
            } else {
                percentualSalario = (parcelaMensal / salario) * 100;
                if (percentualSalario <= 30) {
                    System.out.println("Empréstimo Consignado.");
                } else if (percentualSalario <= 40) {
                    System.out.println("Empréstimo Pessoal.");
                } else {
                    System.out.println("Empréstimo com Garantia.");
                }
            }
            System.out.println("Deseja simular novamente? Digite S (SIM) ou N (NÃO)");
            simular = teclado.next();
        } while ("S".equalsIgnoreCase(simular));
        System.out.println("Simulação Finalizada!");
    }
}