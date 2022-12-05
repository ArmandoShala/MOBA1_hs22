package ch.codebros.moba1_p5_calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var display: TextView
    private var firstNumber: Number? = null
    private var secondNumber: Number? = null
    private var operator: String = ""
    private var result: String = ""
    private var decimalFormat = DecimalFormat("#,###.##")

    private var placeholderNumber: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        arrayOf<Button>(
            findViewById(R.id.number_0),
            findViewById(R.id.number_01),
            findViewById(R.id.number_02),
            findViewById(R.id.number_03),
            findViewById(R.id.number_04),
            findViewById(R.id.number_05),
            findViewById(R.id.number_06),
            findViewById(R.id.number_07),
            findViewById(R.id.number_08),
            findViewById(R.id.number_09),
            findViewById(R.id.divide),
            findViewById(R.id.multiply),
            findViewById(R.id.minus),
            findViewById(R.id.clear),
            findViewById(R.id.plus),
            findViewById(R.id.equals),
        ).forEach { it.setOnClickListener(this) }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.number_0 -> addDigitToDisplay("0")
                R.id.number_01 -> addDigitToDisplay("1")
                R.id.number_02 -> addDigitToDisplay("2")
                R.id.number_03 -> addDigitToDisplay("3")
                R.id.number_04 -> addDigitToDisplay("4")
                R.id.number_05 -> addDigitToDisplay("5")
                R.id.number_06 -> addDigitToDisplay("6")
                R.id.number_07 -> addDigitToDisplay("7")
                R.id.number_08 -> addDigitToDisplay("8")
                R.id.number_09 -> addDigitToDisplay("9")

                R.id.divide -> selectOperant("/")
                R.id.multiply -> selectOperant("*")
                R.id.minus -> selectOperant("-")
                R.id.plus -> selectOperant("+")

                R.id.clear -> reset()
                R.id.equals -> calculate()
            }
        }
    }

    private fun selectOperant(s: String) {
        operator = s
        setNumbers()
    }

    private fun setNumbers() {
        val currNumb = display.text.toString().toDouble()
        if (firstNumber == null)
            firstNumber = currNumb
        else
            secondNumber = currNumb

        placeholderNumber = true
    }

    private fun addDigitToDisplay(digit: String) {
        if (placeholderNumber) {
            display.text = digit
            placeholderNumber = false
        } else {
            "${display.text}$digit".also { display.text = it }
        }
    }

    private fun calculate() {
        setNumbers()
        val calculation = when (operator) {
            "/" -> (firstNumber!!.toDouble() / secondNumber!!.toDouble())
            "*" -> (firstNumber!!.toDouble() * secondNumber!!.toDouble())
            "-" -> (firstNumber!!.toDouble() - secondNumber!!.toDouble())
            "+" -> (firstNumber!!.toDouble() + secondNumber!!.toDouble())
            else -> 0.0
        }
        display.text = decimalFormat.format(calculation)
        reverteToInitState()
    }

    private fun clearDisplay() {
        display.text = "0"
    }

    private fun reverteToInitState() {
        firstNumber = null
        secondNumber = null
        operator = ""
        result = ""
        placeholderNumber = true
    }

    private fun reset() {
        clearDisplay()
        reverteToInitState()
    }

}