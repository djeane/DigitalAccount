package bank.com.model.sendmoney

import com.google.gson.annotations.SerializedName

class AccountsReceiverResponse(
    @SerializedName("ClienteId") val id: String,
    @SerializedName("token") val token: String,
    @SerializedName("valor") val valor: Double
)

