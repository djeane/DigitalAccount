package bank.com.core.di

import bank.com.model.api.DigitalAccountApi
import bank.com.shared.constants.InjectionTags.OKHTTP_API
import bank.com.shared.constants.InjectionTags.RETROFIT_API
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiInjection {

    val apiModule = Kodein.Module{

        bind<DigitalAccountApi>() with singleton {
            instance<Retrofit>(RETROFIT_API).create(DigitalAccountApi::class.java)
        }

        bind<Retrofit>(RETROFIT_API) with singleton {
            Retrofit.Builder()
                .baseUrl("http://processoseletivoneon.azurewebsites.net")
                .client(instance(OKHTTP_API))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        bind<OkHttpClient>(OKHTTP_API) with singleton {
            OkHttpClient.Builder().build()
        }
    }
}