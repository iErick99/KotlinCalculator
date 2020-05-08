package com.example.calculator
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.model.Model
import kotlinx.android.synthetic.main.calculator_inputs.*
import kotlinx.android.synthetic.main.operation_result.*
import java.lang.Error
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val model: Model = Model()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClickListenerInputButtons(button_number_0)
        setOnClickListenerInputButtons(button_number_1)
        setOnClickListenerInputButtons(button_number_2)
        setOnClickListenerInputButtons(button_number_3)
        setOnClickListenerInputButtons(button_number_4)
        setOnClickListenerInputButtons(button_number_5)
        setOnClickListenerInputButtons(button_number_6)
        setOnClickListenerInputButtons(button_number_7)
        setOnClickListenerInputButtons(button_number_8)
        setOnClickListenerInputButtons(button_number_9)
        setOnClickListenerInputButtons(button_plus)
        setOnClickListenerInputButtons(button_division)
        setOnClickListenerInputButtons(button_minus)
        setOnClickListenerInputButtons(button_multiply)
        setOnClickListenerInputButtons(button_percentage)

        setOnClickListenerClearButton(button_clear)

        setOnClickListenerEqualsButton(button_equals)

    }

    private fun setOnClickListenerInputButtons(button: Button) {

        button.setOnClickListener{

            model.addNumber(button.text.toString())
            user_input.text = model.getExpression()

        }

    }

    private fun setOnClickListenerClearButton(button: Button) {

        button.setOnClickListener{

            model.clearExpression()
            user_input.text = model.getExpression()
            user_result.text = ""

        }

    }

    private fun setOnClickListenerEqualsButton(button: Button) {

        button.setOnClickListener{

           try {

               val result: String = model.evaluateExpression().toString()
               user_result.text = result
               model.clearExpression()
               model.setExpression(result)

           } catch (error: Exception) {

               user_result.text = "Invalid operation."

           }

        }

    }

}
