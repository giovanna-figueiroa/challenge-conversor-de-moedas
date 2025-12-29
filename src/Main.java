import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultarCotacao consultar = new ConsultarCotacao();

        System.out.println("$$$ Conversor de Moedas $$$");

        System.out.println("Digite a moeda que você tem (ex: USD): ");
        String base = leitura.nextLine().toUpperCase();

        System.out.println("Digite a moeda para converter (ex: BRL): ");
        String alvo = leitura.nextLine().toUpperCase();

        System.out.println("Digite o valor a converter: ");
        double valor = leitura.nextDouble();

        try {
            // Chama a API
            Moeda moeda = consultar.buscaCotacao(base, alvo);

            // Calcula o resultado
            double resultado = valor * moeda.taxa();

            System.out.printf("Cotação atual: 1 %s = %.4f %s%n", base, moeda.taxa(), alvo);
            System.out.printf("Valor final: %.2f %s%n", resultado, alvo);

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Verifique se a moeda existe ou se sua chave API está correta.");
        }
    }
}