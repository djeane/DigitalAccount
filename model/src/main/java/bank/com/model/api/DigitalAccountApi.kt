package bank.com.model.api

import bank.com.model.transferhistory.AccountReceiverResponse
import bank.com.model.sendmoney.AccountSenderRequest
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DigitalAccountApi {

    @GET("/GenerateToken")
    fun generateToken(
        @Query("nome") name: String = "Djeane Barros",
        @Query("email") email: String = "djeanebc@gmail.com"
    ): Single<String>

    @GET("/GetTransfers")
    fun getTransfers(@Query("token") token: String = "26665465456"): Observable<List<AccountReceiverResponse>>

    @POST("/SendMoney")
    fun sendMoney(@Body account: AccountSenderRequest): Single<Boolean>
}