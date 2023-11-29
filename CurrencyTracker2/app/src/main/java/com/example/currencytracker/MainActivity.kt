import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val apiKey = "3e53194ad48e4df2a3037cbbe350541a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratesTextView = findViewById<TextView>(R.id.ratesTextView)
        val amountEditText = findViewById<EditText>(R.id.amountEditText)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        // Используем Retrofit для получения данных о курсах валют
        val call = CurrencyApiClient.apiService.getLatestRates(apiKey)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val rates = response.body()?.rates
                    // Обновляем UI с полученными данными
                    // Например, можно использовать TextView для вывода информации о курсах валют
                    ratesTextView.text = rates.toString()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                // Обработка ошибок
            }
        })

        convertButton.setOnClickListener {
            val amount = amountEditText.text.toString().toDoubleOrNull()
            if (amount != null) {
                // Выполните конвертацию с использованием выбранной валюты и отобразите результат в resultTextView
                // Например: resultTextView.text = convertedAmount.toString()
            } else {
                // Обработка ошибки ввода
            }
        }
    }
}
