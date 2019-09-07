package bank.com.viewmodel.sendmoney

import java.io.Serializable

data class AccountReceiverUIModel(
    private val fistName: String,
    private val lastName: String,
    private val phoneNumber: String,
    private val id: String,
    private val token: String
) : Serializable {

    fun formattingUserName(): String {
        return "$fistName $lastName"
    }

    fun formattingPhoneNumber(): String {
        return phoneNumber
    }
}