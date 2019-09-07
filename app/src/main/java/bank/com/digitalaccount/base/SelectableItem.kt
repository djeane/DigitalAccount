package bank.com.digitalaccount.base

data class SelectableItem<T>(
    var isSelected: Boolean,
    var model: T,
    var position: Int
)