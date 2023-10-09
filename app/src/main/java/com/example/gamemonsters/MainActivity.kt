package com.example.gamemonsters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gamemonsters.monster.Monster
import com.example.gamemonsters.player.Player

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player = Player(15, 10, 5000..20000)
        player.health = 120000
        val monster = Monster(12, 8, 8000..15000)
        monster.health = 100000

        while (player.isAlive() && monster.isAlive()) {
            player.doAttack(monster)
            if (monster.isAlive()) {
                monster.doAttack(player)
            }
        }

        if (player.isAlive()) {
            Toast.makeText(this, "Игрок победил!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Монстр победил!", Toast.LENGTH_SHORT).show()
        }
    }
}