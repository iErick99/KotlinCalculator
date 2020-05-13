package com.example.calculator.model

import java.util.*
import java.util.regex.Pattern
import kotlin.math.*

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

    fun evaluateExpression(): Double {

        val sc = Scanner(expression)
        var firstValue: Double? = null
        var secondValue: Double = 0.0

        if (sc.hasNextDouble()) {

            firstValue = sc.nextDouble()

        }

        val operator: String = sc.findInLine("[^0-9]*").trim()

        if (sc.hasNextDouble()) {

            secondValue = sc.nextDouble()

        }

        if (firstValue != null) {
            return when (operator) {
                "+" -> firstValue + secondValue
                "-" -> firstValue - secondValue
                "/" -> firstValue / secondValue
                "*" -> firstValue * secondValue
                "%" -> firstValue % secondValue
                "^" -> firstValue.pow(secondValue)
                else -> throw RuntimeException("Unknown operator: $operator")
            }
        } else {
            return when (operator) {
                "SIN(" -> sin(secondValue)
                "COS(" -> cos(secondValue)
                "TAN(" -> tan(secondValue)
                "CSC(" -> asin(secondValue)
                "SEC(" -> acos(secondValue)
                "CTG(" -> atan(secondValue)
                "√" -> sqrt(secondValue)
                else -> throw RuntimeException("Unknown operator: $operator")
            }

        }

    }

}