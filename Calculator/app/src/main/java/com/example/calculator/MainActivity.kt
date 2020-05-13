package com.example.calculator

import android.app.ActionBar
import android.content.DialogInterface
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.model.Model
import kotlinx.android.synthetic.main.calculator_inputs.*
import kotlinx.android.synthetic.main.operation_result.*


class MainActivity : AppCompatActivity() {

    private val model: Model = Model()
    private var specialCharacter: Boolean = false

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
        setOnClickListenerInputButtons(button_elevate)
        setOnClickListenerInputButtons(button_square)
        setOnClickListenerInputButtons(button_percentage)
        setOnClickListenerInputSpecialButtons(button_sin)
        setOnClickListenerInputSpecialButtons(button_cos)
        setOnClickListenerInputSpecialButtons(button_tan)
        setOnClickListenerInputSpecialButtons(button_csc)
        setOnClickListenerInputSpecialButtons(button_sec)
        setOnClickListenerInputSpecialButtons(button_ctg)

        setOnClickListenerClearButton(button_clear)

        setOnClickListenerEqualsButton(button_equals)

    }

    private fun setOnClickListenerInputButtons(button: Button) {

        button.setOnClickListener{

            if (model.getExpression().endsWith(") ")) {

                model.addNumber("* ")

            }

            if (button.text.toString().toIntOrNull() != null) {

                model.addNumber(button.text.toString().toDouble().toString() + " ")

            } else {

                model.addNumber(button.text.toString() + " ")

            }

            if (specialCharacter) {

                model.addNumber(") ")
                specialCharacter = false

            }

            user_input.text = model.getExpression()

        }

    }

    private fun setOnClickListenerClearButton(button: Button) {

        button.setOnClickListener{

            specialCharacter = false
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

    private fun setOnClickListenerInputSpecialButtons(button: Button) {

        button.setOnClickListener{

            if (model.getExpression().takeLast(1).toIntOrNull() != null) {

                model.addNumber("*")

            }

            model.addNumber(button.text.toString() + "(")
            specialCharacter = true
            user_input.text = model.getExpression()

        }

    }

}
