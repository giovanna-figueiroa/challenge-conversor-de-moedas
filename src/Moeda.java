import com.google.gson.annotations.SerializedName;

public record Moeda(
        @SerializedName("base_code") String base,
        @SerializedName("target_code") String alvo,
        @SerializedName("conversion_rate") double taxa
) {
}
