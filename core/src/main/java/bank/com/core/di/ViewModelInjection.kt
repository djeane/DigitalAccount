package bank.com.core.di

import org.kodein.di.Kodein

class ViewModelInjection{

    val module = Kodein.Module{
        import(module = ModelInjection().model)
    }
}