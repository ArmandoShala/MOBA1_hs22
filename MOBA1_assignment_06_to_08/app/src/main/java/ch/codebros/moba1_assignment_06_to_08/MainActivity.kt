package ch.codebros.moba1_assignment_06_to_08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var stockData: MutableList<Stock>
    private lateinit var adapter: CustomAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.stockRecyclerview)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = CustomAdapter(stockData)


        stockData = mutableListOf(
            Stock("Apple", "AAPL", 115.69),
            Stock("Microsoft", "MSFT", 214.36),
            Stock("Google", "GOOGL", 1519.45),
            Stock("Salesforce", "CRM", 255.52),
            Stock("Facebook", "FB", 260.02),
            Stock("Amazon", "AMZN", 3201.86),
            Stock("eBay", "EBAY", 54.05),
            Stock("Twitter", "TWTR", 45.41),
            Stock("Snapchat", "SNAP", 28.11)
        )

        val adapter = CustomAdapter(stockData)



    }
}