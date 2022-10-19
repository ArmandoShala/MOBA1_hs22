package ch.codebros.moba1_assignment_06_to_08

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val items: MutableList<Stock>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Stock) {
//            itemView.stockName.text = item.name
        }
    }
}

//    private lateinit var binding: ItemRowBinding
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflator = LayoutInflater.from(parent.context)
//        binding = ItemRowBinding.inflate(inflator, parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(items[position])
//    }
//
//    override fun getItemCount() = items.size
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.root) {
//        fun bind(item: Stock) {
//            binding.apply {
//                name.text = item.name
//                stockPricePerUnit = item.value.toString()
//            }
//        }
//    }}
