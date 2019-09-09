package bank.com.model.transferhistory

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AccountReceiverResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("ClienteId") val clienteId: Int,
    @SerializedName("token") val token: String,
    @SerializedName("valor") val valor: Double,
    @SerializedName("Data") val date: String
) : Serializable

