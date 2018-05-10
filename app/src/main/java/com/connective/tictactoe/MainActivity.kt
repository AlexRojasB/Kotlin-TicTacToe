package com.connective.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    var Player1 = ArrayList<Int>()
    var Player2 = ArrayList<Int>()
    var ActivePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buClick(view:View){
        val buSelected = view as Button
        var cellID = 0
        when(buSelected.id){
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
        }

       //Toast.makeText(this, "ID: " + cellID, Toast.LENGTH_LONG).show()
        PlayGame(cellID, buSelected)
        CheckWinner()
    }

    fun PlayGame(cellId:Int, buSelected:Button){
        if (ActivePlayer ==1){
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.GREEN)
            Player1.add(cellId)
            ActivePlayer =2
            AutoPlay()
        }else{
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.BLUE)
            Player2.add(cellId)
            ActivePlayer =1
        }
        buSelected.isEnabled = false

    }

    fun CheckWinner(){
        var winner = -1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            winner = 2
        }

        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            winner = 1
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            winner = 2
        }

        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            winner = 1
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            winner = 2
        }

        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            winner = 2
        }

        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            winner = 2
        }

        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            winner = 2
        }

        if (winner != -1){
            Toast.makeText(this, "Player$winner win the game", Toast.LENGTH_LONG).show()
        }
    }

    fun AutoPlay() {
        var emptyCells=ArrayList<Int>()
        for (cellID in 1..9){
            if (!(Player1.contains(cellID) || Player2.contains(cellID)))
            {
                emptyCells.add(cellID)
            }
        }

        val r = Random()
        val randIndex=r.nextInt(emptyCells.size - 0) + 0
        val emptyCellId = emptyCells[randIndex]

        var buSelect:Button?
        when(emptyCellId){
            1 -> buSelect = findViewById(R.id.btn1)
            2 -> buSelect = findViewById(R.id.btn2)
            3 -> buSelect = findViewById(R.id.btn3)
            4 -> buSelect = findViewById(R.id.btn4)
            5 -> buSelect = findViewById(R.id.btn5)
            6 -> buSelect = findViewById(R.id.btn6)
            7 -> buSelect = findViewById(R.id.btn7)
            8 -> buSelect = findViewById(R.id.btn8)
            9 -> buSelect = findViewById(R.id.btn9)
            else -> {
                buSelect = findViewById(R.id.btn1)
            }
        }
        PlayGame(emptyCellId, buSelect)
    }
}
