package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var rollBtn: Button
    private lateinit var diceImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        diceImg = findViewById(R.id.dice_img)

        rollBtn = findViewById(R.id.roll_btn)

        rollBtn.setOnClickListener {
            diceImg.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                diceImg.animate().apply {
                    duration = 100
                    rotationYBy(360f)
                }.start()
            }
            rollDice()
        }


    }

    private fun rollDice() {

        val drawableImg = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImg.setImageResource(drawableImg)
        Toast.makeText(this, "DiceRolled!", Toast.LENGTH_SHORT).show()
    }
}