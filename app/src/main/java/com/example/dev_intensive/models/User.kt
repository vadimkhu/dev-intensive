package com.example.dev_intensive.models

import java.util.*

class User(val id : String,
           var firstName : String?,
           var lastName : String?,
           var avatar : String?,
           var rating : Int = 0,
           var respect : Int = 0,
           var lastVisit : Date? = Date(),
           var isOnline : Boolean = false) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    init {
        println("It's alive!")
        println("And his name is $firstName $lastName!!!")
    }

    companion object Factory {
        private var lastid: Int = -1
        fun makeUeser(fullName: String): User {
            lastid++
            val parts = fullName?.trim()?.split(" ")
            val firstName = parts?.getOrNull(0)?.ifEmpty { null }
            val lastName = parts?.getOrNull(1)?.ifEmpty { null }
            return User(id = "$lastid", firstName = firstName, lastName = lastName)
        }
    }
}