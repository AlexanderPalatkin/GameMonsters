package com.example.gamemonsters.player

import com.example.gamemonsters.base.BaseEntity
import kotlin.random.Random

class Player(
    attack: Int,
    defense: Int,
    damageRange: IntRange
) : BaseEntity(attack, defense, damageRange) {

    override var health: Int = Random.nextInt()
        set(value) {
            field = if (value < 0) 0 else value
        }

    private var maxHealth = health

    private var healingCount = 4

    fun heal() {
        if (healingCount > 0 && health > 0) {
            val maxHeal = maxHealth * 0.3
            health += maxHeal.toInt()
            if (health > maxHealth) {
                health = maxHealth
            }
            healingCount--
        }
    }
}