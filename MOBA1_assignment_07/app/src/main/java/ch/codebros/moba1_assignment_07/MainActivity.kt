package ch.codebros.moba1_assignment_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.codebros.moba1_assignment_07.model.Stock
import ch.codebros.moba1_assignment_07.model.StockAdapter
import ch.codebros.moba1_assignment_07.model.StockService

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var stockRecyclerView = findViewById<RecyclerView>(R.id.stockRecyclerView)

        // get first data from this api
        val URL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey=YHT167YZ7Z121D55"
        val stockService = StockService();
        val items = stockService.callStocksAPI(this);

        stockRecyclerView.adapter = StockAdapter(items)
        stockRecyclerView.layoutManager = LinearLayoutManager(this);
    }
}