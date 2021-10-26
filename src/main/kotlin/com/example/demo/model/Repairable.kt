package com.example.demo.model

interface Repairable {
    fun excludeEngine() : Any
    fun excludeSuspension() : Any
}