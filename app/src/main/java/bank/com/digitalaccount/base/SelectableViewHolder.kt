package bank.com.digitalaccount.base

import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView

abstract class SelectableViewHolder<T>(
    view: View,
    private val itemSelectedListener: OnItemSelected<T>
) : RecyclerView.ViewHolder(view), View.OnClickListener {

    abstract val selectAction: () -> Unit
    abstract val deselectAction: () -> Unit

    protected lateinit var selectableItem: SelectableItem<T>

    @CallSuper
    open fun bind(selectableItem: SelectableItem<T>) {
        this.selectableItem = selectableItem
        itemView.setOnClickListener(this)
        updateSelection()
    }

    private fun updateSelection() {
        if (selectableItem.isSelected) selectAction else deselectAction
    }

    @CallSuper
    override fun onClick(v: View?) {
        selectableItem.isSelected = true
        itemSelectedListener.itemSelected(selectableItem)
    }
}