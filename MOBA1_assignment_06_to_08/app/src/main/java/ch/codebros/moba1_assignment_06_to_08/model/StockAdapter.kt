package ch.codebros.moba1_assignment_06_to_08.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StockAdapter(private val items: List<Stock>) : RecyclerView.Adapter<StockViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StockViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val stock: Stock = items[position]
        holder.bind(stock)
    }

    override fun getItemCount(): Int = items.size
}