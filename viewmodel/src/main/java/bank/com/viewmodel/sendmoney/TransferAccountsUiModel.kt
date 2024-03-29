package bank.com.viewmodel.sendmoney

class TransferAccountsUiModel {
    companion object {
        fun generateUsersTransferList(): ArrayList<AccountReceiverUIModel> {
            val accounts = ArrayList<AccountReceiverUIModel>()

            val account1 = AccountReceiverUIModel(
                fistName = "Fatima",
                lastName = "Santos",
                phoneNumber = "(11) 11111-1111",
                id = 115152,
                clientId = 322551,
                amount = 115.48
            )

            val account2 = AccountReceiverUIModel(
                fistName = "Solange",
                lastName = "Agora",
                phoneNumber = "(11) 85498-9990",
                id = 1544555,
                clientId = 7545330,
                amount = 125.25
            )

            val account3 = AccountReceiverUIModel(
                fistName = "Adriana",
                lastName = "Oliveira",
                phoneNumber = "(11) 59599-1111",
                id = 751545,
                amount = 146.78,
                clientId = 1646645,
                image = "https://specials-images.forbesimg.com/imageserve/5ceec355142c500008f42068/1920x0.jpg?cropX1=32&cropX2=1982&cropY1=257&cropY2=2207"
            )

            val account4 = AccountReceiverUIModel(
                fistName = "Paola Oliveira",
                lastName = "Agora",
                phoneNumber = "(11) 69996-1895",
                id = 662067,
                amount = 87.21,
                clientId = 5665310,
                image = "https://pbs.twimg.com/media/C6aEHi0WgAAWygX.jpg"
            )

            val account5 = AccountReceiverUIModel(
                fistName = "Giovanna",
                lastName = "Sousa",
                phoneNumber = "(11) 58954-1134",
                id = 56892,
                amount = 325.25,
                clientId = 3265600,
                image = "https://i.pinimg.com/originals/11/90/5d/11905d12b0c4a35efa466f9715db8615.jpg"
            )

            val account6 = AccountReceiverUIModel(
                fistName = "Ana Paula",
                lastName = "Braga",
                phoneNumber = "(11) 42423-5545",
                id = 2552154,
                amount = 258.21,
                clientId = 2266005
            )

            val account7 = AccountReceiverUIModel(
                fistName = "Barbara",
                lastName = "Paz",
                phoneNumber = "(19) 13434-4343",
                id = 3006,
                amount = 136.84,
                clientId = 655323,
                image = "https://i.pinimg.com/280x280_RS/b6/96/63/b69663ced89d73b051eeb1d58f574d63.jpg"
            )

            val account8 = AccountReceiverUIModel(
                fistName = "Amanda",
                lastName = "Silva",
                phoneNumber = "(11) 43433-3434",
                id = 2121233,
                amount = 65.84,
                clientId = 15445
            )

            val account9 = AccountReceiverUIModel(
                fistName = "Ana Claudia",
                lastName = "Amora",
                phoneNumber = "(11) 43434-3232",
                id = 5999,
                amount = 45.45,
                clientId = 26565,
                image = "https://static1.purebreak.com.br/articles/1/32/01/@/18847-katniss-950x0-1.jpg"
            )

            val account10 = AccountReceiverUIModel(
                fistName = "Stephane",
                lastName = "Boa Vida",
                phoneNumber = "(11) 43434-4343",
                id = 5496565,
                amount = 54.81,
                clientId = 32656,
                image = "https://i1.wp.com/profilesio.com/wp-content/uploads/Dina-Denoire-Bio-Age-Height-Weight-Profile-Family.jpg?fit=800%2C970&ssl=1"
            )

            val account11 = AccountReceiverUIModel(
                fistName = "Jeane",
                lastName = "Barros",
                phoneNumber = "(11) 33222-4343",
                id = 8484,
                amount = 94.72,
                clientId = 464
            )

            val account12 = AccountReceiverUIModel(
                fistName = "Ester",
                lastName = "Santos",
                phoneNumber = "(11) 44344-3333",
                id = 565565,
                amount = 58.40,
                clientId = 6656
            )

            val account13 = AccountReceiverUIModel(
                fistName = "Adria",
                lastName = "Silva",
                phoneNumber = "(11) 43433-3434",
                id = 1166,
                amount = 67.47,
                clientId = 546,
                image = "https://www.cheatsheet.com/wp-content/uploads/2019/09/Rihanna-2.jpg"
            )

            val account14 = AccountReceiverUIModel(
                fistName = "Claudiana",
                lastName = "Oliveira",
                phoneNumber = "(11) 59591-0591",
                id = 35466,
                amount = 48.92,
                clientId = 1146,
                image = "https://pmctvline2.files.wordpress.com/2017/11/supergirl-chyler-leigh.jpg?w=620"
            )

            val account15 = AccountReceiverUIModel(
                fistName = "Fernanda",
                lastName = "Oliveira",
                phoneNumber = "(11) 43434-3567",
                id = 1642131,
                amount = 45.21,
                clientId = 4545,
                image = "https://pbs.twimg.com/profile_images/1049168731165749248/3NErkIpF_400x400.jpg"
            )

            val account16 = AccountReceiverUIModel(
                fistName = "Juliana",
                lastName = "Ferreira",
                phoneNumber = "(11) 43434-4444",
                id = 16464630,
                amount = 125.47,
                clientId = 1646463
            )

            val account17 = AccountReceiverUIModel(
                fistName = "Sonia",
                lastName = "Braga",
                phoneNumber = "(11) 56565-3444",
                id = 16464630,
                amount = 152.64,
                clientId = 1646463,
                image = "https://i.pinimg.com/originals/86/6f/ed/866fed5700001aa62e23d735b8a685f5.jpg"
            )

            val account18 = AccountReceiverUIModel(
                fistName = "Silvana",
                lastName = "Soares",
                phoneNumber = "(11) 95911-1606",
                id = 145582,
                amount = 154.85,
                clientId = 124544
            )

            val account19 = AccountReceiverUIModel(
                fistName = "Julia",
                lastName = "Junqueira",
                phoneNumber = "(11) 99888-5851",
                id = 16464630,
                amount = 175.82,
                clientId = 1646463,
                image = "https://media.fstatic.com/Cu_B-N6NrW16LyxVJSNvbZ4iMXc=/full-fit-in/290x478/media/artists/avatar/2018/05/chyler-leigh_a153114_Um7gBjh.png"
            )

            val account20 = AccountReceiverUIModel(
                fistName = "Katie",
                lastName = "McGrath",
                phoneNumber = "(21) 44311-1111",
                id = 16464630,
                amount = 162.42,
                clientId = 1646463,
                image = "https://d27o7y1r7mnbwc.cloudfront.net/media/uploads/clients/katie-mcgrath/images/2017-02-25_204132_mcgrath_katie.jpg"
            )

            val account21 = AccountReceiverUIModel(
                fistName = "Chyler",
                lastName = "Leigh",
                phoneNumber = "(61) 42424-5656",
                id = 16464630,
                amount = 156.78,
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

    }
}