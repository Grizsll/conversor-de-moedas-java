import com.google.gson.annotations.SerializedName;
import java.util.Map;

// Esta classe representa a estrutura da resposta JSON da API
public class Taxas {

    // O campo "conversion_rates" no JSON será mapeado para este Map
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    /**
     * Retorna a taxa de conversão para uma moeda específica.
     * @param moeda O código da moeda (ex: "BRL", "USD").
     * @return A taxa de conversão.
     */
    public double getTaxa(String moeda) {
        if (conversionRates.containsKey(moeda)) {
            return conversionRates.get(moeda);
        } else {
            // Lança uma exceção se a moeda não for encontrada
            throw new IllegalArgumentException("Moeda '" + moeda + "' não encontrada nas taxas de conversão.");
        }
    }
}
