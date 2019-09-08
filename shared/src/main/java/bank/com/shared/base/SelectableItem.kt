package bank.com.shared.base

data class SelectableItem<T>(
    var isSelected: Boolean,
    var model: T,
    var position: Int
)