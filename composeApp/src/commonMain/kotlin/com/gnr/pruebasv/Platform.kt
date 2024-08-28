package com.gnr.pruebasv

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform