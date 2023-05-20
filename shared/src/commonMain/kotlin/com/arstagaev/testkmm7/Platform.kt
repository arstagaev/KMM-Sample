package com.arstagaev.testkmm7

interface Platform {
    val name: String
}

//expect fun getPlatformName(): Platform
expect fun getPlatformName(): String