package bank.com.model.home

import bank.com.model.api.DigitalAccountApi

class GenerateTokenModel(private val digitalAccountApi: DigitalAccountApi){
    fun generateToken(name: String, email: String) = digitalAccountApi.generateToken(name, email)
}