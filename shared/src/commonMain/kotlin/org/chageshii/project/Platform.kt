package org.chageshii.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform