package ch.codebros.moba1_assignment_08

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.codebros.moba1_assignment_08.model.Stock
import ch.codebros.moba1_assignment_08.model.StockAdapter

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




    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        val settings = this.getSharedPreferences("prefsfile", MODE_PRIVATE)
        val editor = settings.edit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(savedStock in settings.getStringSet("savedStocks", setOf())!!) {
            items.add(Stock(savedStock.split(",")[0], savedStock.split(",")[1], savedStock.split(",")[2].toDouble()))
        }

        val stockRecyclerView = findViewById<RecyclerView>(R.id.stockRecyclerView)
        stockRecyclerView.adapter = StockAdapter(items)
        stockRecyclerView.layoutManager = LinearLayoutManager(this);

        val btnAddStock = findViewById<android.widget.Button>(R.id.btnAddStock)

        btnAddStock.setOnClickListener {
            val stockName = findViewById<android.widget.EditText>(R.id.addStockName).text.toString()
            val stockSymbol = findViewById<android.widget.EditText>(R.id.addStockNumber).text.toString().toDouble()
            items.add(Stock(stockName, "" , stockSymbol))
            editor.putStringSet("savedStocks", items.map { it.name + "," + it.symbol + "," + it.value }.toSet())
            editor.apply()
            editor.commit()
            stockRecyclerView.adapter?.notifyDataSetChanged()
        }
    }
}