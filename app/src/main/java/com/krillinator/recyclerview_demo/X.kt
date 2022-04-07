package com.krillinator.recyclerview_demo

class X(var b: String) {            // Primary Constructor

    val a = println("a")

    constructor() : this("") {   // b = aaa AND Secondary Constructor
        println("c")
    }

    init {
        println("b")
    }
}
