package com.example.intent

class Calculation(private val first: String, private val second: String) {
    private fun convertToInt(value: String): Double = value.toDouble()

    fun sum():String = (convertToInt(first) + convertToInt(second)).toString()
    fun minus():String = (convertToInt(first) - convertToInt(second)).toString()
    fun mult():String = (convertToInt(first) * convertToInt(second)).toString()
    fun div():String = (convertToInt(first) / convertToInt(second)).toString()

}