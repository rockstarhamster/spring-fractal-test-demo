package com.example.demo.model

class Truck(
    val name: String
) : Repairable {
    override fun excludeEngine(): Any {
        TODO("Not yet implemented")
    }

    override fun excludeSuspension(): Any {
        TODO("Not yet implemented")
    }
}