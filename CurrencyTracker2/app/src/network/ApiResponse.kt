// ApiResponse.kt
data class ApiResponse(val disclaimer: String, val license: String, val timestamp: Long, val base: String, val rates: Map<String, Double>)
