package ch.codebros.moba1_colorclicker

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import ch.codebros.moba1_colorclicker.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var firstFragment: FirstFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // store fragment and call functions
//        if (firstFragment === null) {
//            firstFragment = supportFragmentManager.findFragmentByTag("myFragmentTag") as FirstFragment
//        }

        val difficulty: Difficulty = when (item.itemId) {
            R.id.action_settingsEasy -> Difficulty.EASY
            R.id.action_settingsMedium -> Difficulty.MEDIUM
            R.id.action_settingsHard -> Difficulty.HARD
            else -> Difficulty.EASY
        }

//        firstFragment?.setAmountOfButtons(difficulty.value)
        Snackbar.make(binding.root, "Set difficulty to " + difficulty.name, Snackbar.LENGTH_LONG) .setAction("Action", null).show()
//        firstFragment?.initTable()
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    // create enum with difficulty levels and values and a function to get the value
    enum class Difficulty(val value: Int) {
        // easy = 5, medium = 10, hard = 15
        EASY(5),
        MEDIUM(10),
        HARD(15);

        companion object {
            fun getDifficultyValue(difficulty: Difficulty): Int {
                return difficulty.value
            }
        }
    }

}