package ch.codebros.moba1_assignment_06_to_08.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.codebros.moba1_assignment_06_to_08.R

class StockViewHolder(inflator: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
    inflator.inflate(
        R.layout.stockitem, parent, false
    )
) {
    private var nameView: TextView? = null
    private var symbolView: TextView? = null
    private var valueView: TextView? = null

    init {
        nameView = itemView.findViewById(R.id.name)
//        symbolView = itemView.findViewById(R.id.symbol) fixme: use this in future assignments
        valueView = itemView.findViewById(R.id.value)
    }

    fun bind(stock: Stock) {
        nameView?.text = stock.name
        symbolView?.text = stock.symbol
        valueView?.text = stock.value.toString()
    }
}
