package ch.codebros.moba1_assignment_06_to_08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.codebros.moba1_assignment_06_to_08.model.Stock
import ch.codebros.moba1_assignment_06_to_08.model.StockAdapter

class MainActivity : AppCompatActivity() {

    val items = mutableListOf(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var stockRecyclerView = findViewById<RecyclerView>(R.id.stockRecyclerView)
        stockRecyclerView.adapter = StockAdapter(items)
        stockRecyclerView.layoutManager = LinearLayoutManager(this);
    }
}