package bank.com.shared.base

interface OnItemSelected<T> {
    fun itemSelected(selectableItem: SelectableItem<T>)
}