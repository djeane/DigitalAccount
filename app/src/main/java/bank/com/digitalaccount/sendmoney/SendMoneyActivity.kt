package bank.com.digitalaccount.sendmoney

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import bank.com.digitalaccount.R
import bank.com.shared.annotations.Inject
import bank.com.shared.base.BaseActivity
import bank.com.shared.constants.InjectionTags.SEND_MONEY_VIEW_MODEL
import bank.com.shared.extensions.getTyped
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import bank.com.viewmodel.sendmoney.SendMoneyViewModel
import kotlinx.android.synthetic.main.activity_send_money.*

@Inject(SEND_MONEY_VIEW_MODEL)
class SendMoneyActivity : BaseActivity() {

    private val viewModel by lazy {
        viewModels.getTyped<SendMoneyViewModel>(SEND_MONEY_VIEW_MODEL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money)
        setupToolbar()
        title = getString(R.string.home_title)
        setAdapter()
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
            clientId = 322551,
            image = "http://pm1.narvii.com/6883/afc7e8c1d6ff2a281f3ae3dbdb3186bc8289b21fr1-450-650v2_uhq.jpg"
        )


        val account2 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 1544555,
            clientId = 7545330,
            image = "http://br.web.img3.acsta.net/c_215_290/pictures/17/05/11/16/34/566535.jpg"
        )

        val account3 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 751545,
            clientId = 1646645,
            image = "https://specials-images.forbesimg.com/imageserve/5ceec355142c500008f42068/1920x0.jpg?cropX1=32&cropX2=1982&cropY1=257&cropY2=2207"
        )

        val account4 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 662067,
            clientId = 5665310,
            image = "https://pbs.twimg.com/media/C6aEHi0WgAAWygX.jpg"
        )

        val account5 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 56892,
            clientId = 3265600,
            image = "https://i.pinimg.com/originals/11/90/5d/11905d12b0c4a35efa466f9715db8615.jpg"
        )

        val account6 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 2552154,
            clientId = 2266005,
            image = "http://www.anaivanovic.com/sites/default/files/styles/flexslider_full_mobile/public/profile.jpg?itok=50Q_EqHf"
        )

        val account7 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 3006,
            clientId = 655323,
            image = "https://i.pinimg.com/280x280_RS/b6/96/63/b69663ced89d73b051eeb1d58f574d63.jpg"
        )

        val account8 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 2121233,
            clientId = 15445,
            image = "http://pm1.narvii.com/6557/a47ebca8de252cd5dd159949b9a7a6492b9e6ec8_hq.jpg"
        )

        val account9 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 5999,
            clientId = 26565,
            image = "https://static1.purebreak.com.br/articles/1/32/01/@/18847-katniss-950x0-1.jpg"
        )

        val account10 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 5496565,
            clientId = 32656,
            image = "https://i1.wp.com/profilesio.com/wp-content/uploads/Dina-Denoire-Bio-Age-Height-Weight-Profile-Family.jpg?fit=800%2C970&ssl=1"
        )

        val account11 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 8484,
            clientId = 464,
            image = "https://www.thefandomentals.com/wp-content/uploads/2018/03/Katniss-screen.jpg"
        )

        val account12 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 565565,
            clientId = 6656,
            image = "https://c8.alamy.com/comp/C68ABF/yaya-dacosta-at-arrivals-for-the-kids-are-all-right-premiere-landmark-C68ABF.jpg"
        )

        val account13 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 1166,
            clientId = 546,
            image = "https://www.cheatsheet.com/wp-content/uploads/2019/09/Rihanna-2.jpg"
        )

        val account14 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 35466,
            clientId = 1146,
            image = "https://pmctvline2.files.wordpress.com/2017/11/supergirl-chyler-leigh.jpg?w=620"
        )

        val account15 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 1642131,
            clientId = 4545,
            image = "https://pbs.twimg.com/profile_images/1049168731165749248/3NErkIpF_400x400.jpg"
        )

        val account16 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463,
            image = "https://static.tvgcdn.net/mediabin/showcards/celebs/c/thumbs/chyler-leigh_768x1024.png"
        )

        val account17 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463,
            image = "https://i.pinimg.com/originals/86/6f/ed/866fed5700001aa62e23d735b8a685f5.jpg"
        )

        val account18 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 145582,
            clientId = 124544,
            image = "https://st2.depositphotos.com/3752845/10266/i/950/depositphotos_102662746-stock-photo-chyler-leigh-at-supergirl.jpg"
        )

        val account19 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463,
            image = "https://media.fstatic.com/Cu_B-N6NrW16LyxVJSNvbZ4iMXc=/full-fit-in/290x478/media/artists/avatar/2018/05/chyler-leigh_a153114_Um7gBjh.png"
        )

        val account20 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463,
            image = "https://d27o7y1r7mnbwc.cloudfront.net/media/uploads/clients/katie-mcgrath/images/2017-02-25_204132_mcgrath_katie.jpg"
        )

        val account21 = AccountReceiverUIModel(
            fistName = "Solange",
            lastName = "Agora",
            phoneNumber = "(11) 11111-1111",
            id = 16464630,
            clientId = 1646463,
            image = "https://cdn-04.independent.ie/migration_catalog/article29020325.ece/56f13/AUTOCROP/w620/katie-mcgrath"
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
