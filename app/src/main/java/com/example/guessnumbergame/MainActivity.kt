package com.example.guessnumbergame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    var checkCount = 0
    var guessNumber = 0
    val rand = Random()
    var gameContinue = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       guessNumber = rand.nextInt(1000)
    }

    fun checkTheNumber(view: View){
        if(gameContinue) {
            checkCount++

            val panel = findViewById(R.id.numberPanel) as EditText

            val number = panel.text.toString().toInt()

            when (number) {
                in 1..1000 -> if (number == guessNumber) {
                    Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                    gameContinue = false
                    showResult()
                } else if (number > guessNumber)
                    Toast.makeText(this, "The guess number is less !!!", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "The guess number is more !!!", Toast.LENGTH_SHORT).show()

                else -> Toast.makeText(
                    this,
                    "The hidden number is in the range from 1 to 1000.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            Toast.makeText(this, guessNumber.toString(), Toast.LENGTH_SHORT).show()
        }
        else{
         restartGame()
        }
    }

    fun showResult(){
        val panel = findViewById(R.id.numberPanel) as EditText
        panel.isEnabled = false;

        val button = findViewById(R.id.button) as Button
        button.text = "PLAY AGAIN?"

        panel.setText("GAME OVER. Count of attemps: $checkCount")
    }

    fun restartGame(){
        val panel = findViewById(R.id.numberPanel) as EditText
        panel.setText("")
        panel.isEnabled = true;

        val button = findViewById(R.id.button) as Button
        button.text = "CHECK"

        checkCount = 0
        guessNumber = rand.nextInt(1000)
        gameContinue = true;
    }
}
