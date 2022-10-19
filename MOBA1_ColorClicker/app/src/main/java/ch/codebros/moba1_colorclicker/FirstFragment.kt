package ch.codebros.moba1_colorclicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableRow
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
    private var clicks: Int = 0
    private var startTimer: Long = 0
    private var endTimer: Long = 0
    private var totalTime: Long = 0

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
        buttons.clear()
        (0 until amountOfButtons()).forEach { i ->
            buttons
                .add(Button(context)
                    .also {
                        it.text = "$i"
                        it.id = i
                        it.tag = true
                        it.setOnClickListener { view -> onButtonClick(view) }
                        it.isEnabled = false
                    }
                )
        }
    }

    private fun addButtonsToTable() {
        buttons.forEach { btn ->
            run {
                val randNumber = Random().nextInt(amountOfButtons())
                val row = binding.tableLayout.getChildAt(randNumber) as TableRow
                row.addView( btn, 350, 250 );
            }
        }
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
            binding.textViewElapsedTime.text = resources.getString(R.string.elapsed_time, "%.2f".format(endTimer / 1000F))
            totalTime += endTimer
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
        buttons.forEach { btn -> btn.setBackgroundColor(android.R.drawable.btn_default); btn.isEnabled = false }
        binding.buttonStart.isEnabled = true
        binding.textViewElapsedTime.text = totalTime.toString()
    }

    private fun gameContinues() {
        if (clicks >= amountOfButtons()) {
            endGame()
        } else {
            val randomNumber = (1 until amountOfButtons()).random()
            buttons[randomNumber]
                .setBackgroundColor(resources.getColor(R.color.purple_200))
                .also {
                    buttons[randomNumber].tag = true
                }
            startTimer = System.nanoTime()
        }
    }


    public fun setAmountOfButtons(amount: Int) {
        _amountOfButtons = amount
    }

    private fun amountOfButtons(): Int {
        return _amountOfButtons - 1
    }

}