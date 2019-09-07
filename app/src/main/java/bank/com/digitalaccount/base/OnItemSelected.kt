package bank.com.digitalaccount.base

interface OnItemSelected<T> {
    fun itemSelected(selectableItem: SelectableItem<T>)
}