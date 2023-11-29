// CurrencyApi.kt
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("latest.json")
    fun getLatestRates(@Query("app_id") apiKey: String): Call<ApiResponse>
}
