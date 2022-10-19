package ch.codebros.moba1_colorclicker

import android.os.Bundle
import android.os.SystemClock.elapsedRealtime
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ch.codebros.moba1_colorclicker.databinding.FragmentFirstBinding
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var buttons: MutableList<Button> = mutableListOf()
    private var _amountOfButtons: Int = 5
    private var score: Float = 0F
    private var clicks: Int = 0
    private var startTimer: Long = 0
    private var endTimer: Long = 0

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTable()

        binding.buttonStart.setOnClickListener {
            startGame()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    public fun initTable() {
        binding.tableLayout.removeAllViews()
        generateButtons()
        addButtonsToTable()
    }

    private fun generateButtons() {
        val active = true
        // generate buttons
        for (i in 0 until amountOfButtons()) {
            val button = Button(context)
            button.text = "$i"
            button.id = i
            button.tag = active
            button.setOnClickListener { view -> onButtonClick(view) }
            button.isEnabled = false
            buttons.add(button)
        }
    }

    private fun addButtonsToTable() {
        buttons.forEach { btn -> binding.tableLayout.addView(btn) }
    }


    private fun onButtonClick(view: View?) {
        if (view == null) {
            return
        }


        gameContinues()

        if (view.tag == true) {
            view.tag = false
            view.setBackgroundResource(android.R.drawable.btn_default);
            clicks++
            endTimer = System.nanoTime() - startTimer
            // set textViewElapsedTime.text to endTimer in seconds
            binding.textViewElapsedTime.text =
                resources.getString(R.string.elapsed_time, "%.2f".format(endTimer / 1000F))
        }
    }

    private fun startGame() {
        binding.textViewElapsedTime.text = resources.getString(R.string.elapsed_time, "0")
        binding.buttonStart.isEnabled = false
        buttons.forEach { btn -> btn.isEnabled = true }
        gameContinues()
    }

    private fun endGame() {
        clicks = 0
        buttons.forEach { btn -> btn.setBackgroundColor(android.R.drawable.btn_default) }
        binding.buttonStart.isEnabled = true
    }

    private fun gameContinues() {
        if (clicks >= amountOfButtons()) {
            val randomNumber = (1 until amountOfButtons()).random()
            buttons[randomNumber].setBackgroundColor(resources.getColor(R.color.purple_200))
                .also {
                    buttons[randomNumber].tag = true
                }
            startTimer = System.nanoTime()
        } else {
            endGame()
        }
    }


    public fun setAmountOfButtons(amount: Int) {
        _amountOfButtons = amount
    }

    private fun amountOfButtons(): Int {
        return _amountOfButtons - 1
    }

}