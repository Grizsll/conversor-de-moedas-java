import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    // Coloque sua chave da API aqui
    private static final String API_KEY = "4ce07f017b0e77da454c9c45";

    public Taxas buscaTaxas(String moedaBase) {
        // Exemplo de URI da ExchangeRate-API
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moedaBase);

        // Cria a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            // Envia a requisição e obtém a resposta
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Converte o JSON da resposta para um objeto Java
            return new Gson().fromJson(response.body(), Taxas.class);

        } catch (Exception e) {
            // Lança uma exceção em caso de erro na requisição
            throw new RuntimeException("Não foi possível obter as taxas de câmbio. Verifique sua conexão e a chave da API.");
        }
    }
}
