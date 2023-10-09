package com.example.gamemonsters.base

import kotlin.random.Random

abstract class BaseEntity(
    _attack: Int,
    _defense: Int,
    _damageRange: IntRange
) {

    abstract var health: Int

    var attack: Int = _attack
        set(value) {
            field = if (value < 1) {
                1
            } else if (value > 30) {
                30
            } else value
        }

    var defense: Int = _defense
        set(value) {
            field = if (value < 1) {
                1
            } else if (value > 30) {
                30
            } else value
        }

    var damageRange: IntRange = _damageRange
        set(value) {
            field = if (value.first < 0) 0..value.last else value
        }

    fun takeDamage(damage: Int) {
        if (damage > health) {
            health = 0
        } else {
            health -= damage
        }
    }

    private fun isAlive(): Boolean {
        return health > 0
    }

    fun doAttack(target: BaseEntity) {
        if (isAlive() && target.isAlive()) {
            val attackModifier = attack - (target.defense + 1)

            val roll = if (attackModifier > 0) {
                List(attackModifier) { Random.nextInt(1, 7) }
            } else List(1) { Random.nextInt(1, 7) }

            val successful = roll.any { it >= 5 }

            if (successful) {
                val damage = Random.nextInt(damageRange.first, damageRange.last)
                target.takeDamage(damage)
            }
        }
    }
}