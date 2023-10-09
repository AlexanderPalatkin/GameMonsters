package com.example.gamemonsters.monster

import com.example.gamemonsters.base.BaseEntity
import kotlin.random.Random

class Monster(
    attack: Int,
    defense: Int,
    damageRange: IntRange
) : BaseEntity(attack, defense, damageRange) {

    override var health: Int = Random.nextInt()
        set(value) {
            field = if (value < 0) 0 else value
        }
}