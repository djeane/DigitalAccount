package bank.com.model.transferhistory

import com.google.gson.annotations.SerializedName

class AccountReceiverResponse(
    @SerializedName("id") val id: Int, // meu id
    @SerializedName("ClienteId") val clienteId: Int, // id da conta para qual estou transferindo
    @SerializedName("token") val token: String, //é o meu próprio token
    @SerializedName("valor") val valor: Double,
    @SerializedName("Data") val date: String
)

