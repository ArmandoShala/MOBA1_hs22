package ch.codebros.moba1_assignment_07.model

import android.content.Context
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class StockService {

    fun callStocksAPI(context: Context): List<Stock> {
        val requestQueue = Volley.newRequestQueue(context);
        var apiKey = "IBM&apikey=YHT167YZ7Z121D55";
        val baseURL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol";
        val url = "$baseURL=$apiKey";
        val items = mutableListOf<Stock>();
        requestQueue.add(StringRequest(
            com.android.volley.Request.Method.GET, url,
            { response ->
                val jsonObject = JSONObject(response);
                val globalQuote = jsonObject.getJSONObject("Global Quote");
                val symbol = globalQuote.getString("01. symbol");
                val open = globalQuote.getString("02. open");
                val high = globalQuote.getString("03. high");
                val low = globalQuote.getString("04. low");
                val price = globalQuote.getString("05. price");
                val volume = globalQuote.getString("06. volume");
                val latestTradingDay = globalQuote.getString("07. latest trading day");
                val previousClose = globalQuote.getString("08. previous close");
                val change = globalQuote.getString("09. change");
                val changePercent = globalQuote.getString("10. change percent");
                items.add(Stock(symbol, symbol, price.toDouble()));
            },
            { error ->
                Log.e("Volley", error.toString());
            }
        ));

        return items.orEmpty()
    }

    fun getStaticList(): List<Stock> {
        return mutableListOf(
            Stock("Apple", "AAPL", 115.69),
            Stock("Microsoft", "MSFT", 214.36),
            Stock("Google", "GOOGL", 1519.45),
            Stock("Salesforce", "CRM", 255.52),
            Stock("Facebook", "FB", 260.02),
            Stock("Amazon", "AMZN", 3201.86),
            Stock("eBay", "EBAY", 54.05),
            Stock("Twitter", "TWTR", 45.41),
            Stock("Snapchat", "SNAP", 28.11)
        );
    }

}