public class Conversor {
    /**
     * Converte um valor de uma moeda para outra.
     * @param valorOiginal O valor na moeda de origem.
     * @param taxaDeConversao A taxa de conversão para a moeda de destino.
     * @return O valor convertido.
     */
    public static double converter(double valorOiginal, double taxaDeConversao) {
        return valorOiginal * taxaDeConversao;
    }
}
