import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaAPI consulta = new ConsultaAPI();
        int opcao = 0;

        String menu = """
                ***************************************************
                Seja bem-vindo/a ao Conversor de Moeda =]

                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileiro
                4) Real brasileiro =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Sair

                Escolha uma opção válida:
                ***************************************************
                """;

        while (opcao != 7) {
            System.out.println(menu);
            opcao = leitura.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.println("Digite um valor que deseja converter:");
                double valor = leitura.nextDouble();
                String moedaOrigem = "";
                String moedaDestino = "";

                switch (opcao) {
                    case 1:
                        moedaOrigem = "USD";
                        moedaDestino = "ARS";
                        break;
                    case 2:
                        moedaOrigem = "ARS";
                        moedaDestino = "USD";
                        break;
                    case 3:
                        moedaOrigem = "USD";
                        moedaDestino = "BRL";
                        break;
                    case 4:
                        moedaOrigem = "BRL";
                        moedaDestino = "USD";
                        break;
                    case 5:
                        moedaOrigem = "USD";
                        moedaDestino = "COP";
                        break;
                    case 6:
                        moedaOrigem = "COP";
                        moedaDestino = "USD";
                        break;
                }

                try {
                    Taxas taxas = consulta.buscaTaxas(moedaOrigem);
                    double taxaConversao = taxas.getTaxa(moedaDestino);
                    double valorConvertido = Conversor.converter(valor, taxaConversao);

                    System.out.println("------------------------------------");
                    System.out.printf("Valor %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]%n",
                            valor, moedaOrigem, valorConvertido, moedaDestino);
                    System.out.println("------------------------------------");

                } catch (Exception e) {
                    System.out.println("Não foi possível realizar a conversão. Erro: " + e.getMessage());
                }
            } else if (opcao != 7) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        System.out.println("Programa finalizado. Obrigado por usar nosso conversor!");
        leitura.close();
    }
}