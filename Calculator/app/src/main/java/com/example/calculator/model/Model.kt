package com.example.calculator.model

import java.util.*

class Model {

    private var expression: String = ""

    fun addNumber(number: String) {

        expression += number

    }

    fun setExpression(expression: String) {

        this.expression = expression

    }

    fun getExpression(): String {

        return expression

    }

    fun clearExpression() {

        expression = ""

    }

    fun evaluateExpression(): Int {

        val sc = Scanner(expression)
        val firstValue: Int = sc.findInLine("[0-9]*").toInt()
        val operator: String = sc.findInLine("[^0-9]*").trim()
        val secondValue: Int = sc.findInLine("[0-9]*").toInt()

        return when (operator) {
            "+" -> firstValue + secondValue
            "-" -> firstValue - secondValue
            "/" -> firstValue / secondValue
            "*" -> firstValue * secondValue
            "%" -> firstValue % secondValue
            else -> throw RuntimeException("Unknown operator: $operator")
        }

    }

}