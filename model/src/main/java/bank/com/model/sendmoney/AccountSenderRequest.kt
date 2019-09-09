package bank.com.model.sendmoney

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AccountSenderRequest(
    @SerializedName("ClienteId") val clienteId: Int,
    @SerializedName("token") var token: String? = "",
    @SerializedName("valor") val amount: Double
) : Serializable