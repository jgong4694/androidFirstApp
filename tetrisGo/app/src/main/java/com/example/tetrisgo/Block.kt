package com.example.tetrisgo

data class Block(
    var x: Int,
    var y: Int,
    var shape: Array<BooleanArray>,
    var color: Int
)
