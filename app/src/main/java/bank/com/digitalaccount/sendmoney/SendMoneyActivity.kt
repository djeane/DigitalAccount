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
            id = "148484466",
            token = "ml55f4fg655d4glllfbfbxaçamkmldçd"
        )


        val account2 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "1164161548466",
            token = "ml55f4fg655d4gvmklvmldmkmldçd"
        )

        val account3 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "1159988964466",
            token = "ml55f4mkldjflafg655d4gmkmldçd"
        )

        val account4 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "11144666",
            token = "mkmvlvl55f4fg655d4gmkmldçd"
        )

        val account5 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "1648934466",
            token = "ml55f4fg655d4gmkmldadsd23dçd"
        )

        val account6 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "1635524466",
            token = "ml55f4fg655d4gmkmldçd5164"
        )

        val account7 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "1564664",
            token = "ml55f4fg655d4gmkmldçdmhkmkf2"
        )

        val account8 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "1164646466",
            token = "ml55f4fg655d4gmkmlbddbdfbdçd"
        )

        val account9 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "121512696",
            token = "ml55f4fg65adadeqwg5d4gmkmldçd"
        )

        val account10 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "15646",
            token = "ml55f4fg655d4gmkmqqfegegldçd"
        )

        val account11 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "66466",
            token = "ml55f4fg655d4gmkmdadadldçd"
        )

        val account12 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "5979461",
            token = "ml55f4fg655dadadad4gmkmldçd"
        )

        val account13 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "1644613464",
            token = "ml55f4fg655d4asadasgmkmldçd"
        )

        val account14 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "26494946",
            token = "ml55dadadaf4fg655d4gmkmldçd"
        )

        val account15 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "1464946",
            token = "ml55f4fg65daada5d4gmkmldçd"
        )

        val account16 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "116644631464",
            token = "ml55f4fg655ddfd4gmkmldçd"
        )

        val account17 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "226903116",
            token = "jcbjnja54545"
        )

        val account18 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "25903164800",
            token = "mlmlv55"
        )

        val account19 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "1136979416",
            token = "pplfpf15f5f"
        )

        val account20 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "2649497200",
            token = "nnvjkd54v64v6d"
        )

        val account21 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = "164646300011",
            token = "kovkokfd5f4d5"
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
        accounts.add(account19)
        accounts.add(account20)
        accounts.add(account21)
        return accounts
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, SendMoneyActivity::class.java)
    }
}
