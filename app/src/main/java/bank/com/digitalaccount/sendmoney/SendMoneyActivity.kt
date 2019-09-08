package bank.com.digitalaccount.sendmoney

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import bank.com.digitalaccount.R
import bank.com.shared.annotations.Inject
import bank.com.shared.constants.InjectionTags.SEND_MONEY_VIEW_MODEL
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import bank.com.viewmodel.sendmoney.SendMoneyViewModel
import kotlinx.android.synthetic.main.activity_send_money.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.provider

@Inject(SEND_MONEY_VIEW_MODEL)
class SendMoneyActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()

    private lateinit var viewModel: SendMoneyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money)
        injectViewModel()
        setAdapter()
    }

    private fun injectViewModel() {
        val provide: () -> SendMoneyViewModel by kodein.provider(SEND_MONEY_VIEW_MODEL)
        viewModel = provide.invoke()
    }

    private fun setAdapter() {
        rv_accounts_transfer.apply {
            layoutManager = LinearLayoutManager(this@SendMoneyActivity)
            adapter = SendMoneyAdapter(this@SendMoneyActivity, generateUsersTransferList())
        }
    }


    private fun generateUsersTransferList(): ArrayList<AccountReceiverUIModel> {
        val accounts = ArrayList<AccountReceiverUIModel>()

        val account1 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 115152,
            clientId = 322551
        )


        val account2 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 1544555,
            clientId = 7545330
        )

        val account3 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 751545,
            clientId = 1646645
        )

        val account4 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 662067,
            clientId = 5665310
        )

        val account5 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 56892,
            clientId = 3265600
        )

        val account6 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 2552154,
            clientId = 2266005
        )

        val account7 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 3006,
            clientId = 655323
        )

        val account8 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 2121233,
            clientId = 15445
        )

        val account9 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 5999,
            clientId = 26565
        )

        val account10 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 5496565,
            clientId = 32656
        )

        val account11 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 8484,
            clientId = 464
        )

        val account12 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 565565,
            clientId = 6656
        )

        val account13 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 1166,
            clientId = 546
        )

        val account14 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 35466,
            clientId = 1146
        )

        val account15 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 1642131,
            clientId = 4545
        )

        val account16 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463
        )

        val account17 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463
        )

        val account18 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 145582,
            clientId = 124544
        )

        val account19 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463
        )

        val account20 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463
        )

        val account21 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463
        )
        accounts.add(account1)
        accounts.add(account2)
        accounts.add(account3)
        accounts.add(account4)
        accounts.add(account5)
        accounts.add(account6)
        accounts.add(account7)
        accounts.add(account8)
        accounts.add(account9)
        accounts.add(account10)
        accounts.add(account11)
        accounts.add(account12)
        accounts.add(account13)
        accounts.add(account14)
        accounts.add(account15)
        accounts.add(account16)
        accounts.add(account17)
        accounts.add(account18)
        accounts.add(account19)
        accounts.add(account20)
        accounts.add(account21)
        return accounts
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, SendMoneyActivity::class.java)
    }
}
