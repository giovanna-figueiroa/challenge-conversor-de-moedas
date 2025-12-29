import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarCotacao {

    public Moeda buscaCotacao(String base, String alvo) {
        // Coloque sua chave aqui
        String apiKey = "fce6b320b38683ca3a63d12c";

        // Monta o endereço da API (Padrão: /pair/MOEDA_BASE/MOEDA_ALVO)
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base + "/" + alvo);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Transforma o JSON (texto) em um objeto Moeda (Java)
            return new Gson().fromJson(response.body(), Moeda.class);

        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir dessa URL.");
        }
    }
}
