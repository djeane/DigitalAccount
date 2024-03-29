package bank.com.viewmodel.sendmoney

import java.io.Serializable

data class AccountReceiverUIModel(
    val fistName: String,
    val lastName: String,
    val phoneNumber: String,
    val id: Int,
    val clientId: Int,
    var image: String? = null,
    var amount: Double = 0.0
) : Serializable {

    fun formattingUserName(): String {
        return "$fistName $lastName"
    }

    fun formattingPhoneNumber(): String {
        return phoneNumber
    }
}