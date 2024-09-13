import java.io.File;
import java.util.Scanner;

public class SyslogReader {
    public static void main(String[] args) {
        try {
            // Abre o arquivo syslog
            File syslog = new File("/var/log/syslog");
            Scanner scanner = new Scanner(syslog);

            // Lê o arquivo linha por linha
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Verifica se a linha contém eventos de conexão ou desconexão
                if (line.contains("CONNECTED") || line.contains("DISCONNECTED") || line.contains("CONNECTING") || line.contains("DISCONNECTING")) {
                    System.out.println(line); // Exibe a linha que contém o evento
                }
            }

            // Fecha o scanner
            scanner.close();
        } catch (Exception e) {
            // Em caso de erro, exibe a mensagem de erro
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}