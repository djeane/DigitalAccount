package bank.com.shared.base

import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView

abstract class SelectableAdapter<T, VH : SelectableViewHolder<T>>(
    items: List<T>
) : RecyclerView.Adapter<VH>(), OnItemSelected<T> {

    open var selectedItem: SelectableItem<T>? = null
        protected set

    val isAnyItemSelected: Boolean
        get() = selectedItem != null

    private var items = items

    private val selectableItems = ArrayList<SelectableItem<T>>()

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        val selectableItem = getSelectableFromItem(item) ?: createSelectableItem(item, position)
        holder.bind(selectableItem)
    }

    private fun getSelectableFromItem(item: T) = selectableItems.find { it.model == item }

    private fun createSelectableItem(item: T, position: Int): SelectableItem<T> {
        val selectableItem = SelectableItem(
            isSelected = false,
            model = item,
            position = position
        )
        selectableItems.add(selectableItem)
        return selectableItem
    }

    override fun itemSelected(selectableItem: SelectableItem<T>) {
        this.selectedItem = selectedItem
        deselectOthersItems()
        notifyDataSetChanged()
    }

    private fun deselectOthersItems() {
        selectableItems.filter { it.isSelected && it !== selectedItem }
            .map { it.isSelected = false }
    }

    @CallSuper
    open fun updateItems(items: List<T>) {
        this.items = items
        selectableItems.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size
}