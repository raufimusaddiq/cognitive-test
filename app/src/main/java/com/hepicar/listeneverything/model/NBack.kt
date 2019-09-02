package com.hepicar.listeneverything.model

class NBack(var timestampString: Long) {
    var value: Int = 0
    override fun toString(): String {
        return "timestamp:${timestampString} , value:${value}\n"
    }
}