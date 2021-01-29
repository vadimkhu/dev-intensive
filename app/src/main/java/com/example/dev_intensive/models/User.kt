package com.example.dev_intensive.models

import com.example.dev_intensive.utils.Utils
import java.util.*

data class User(val id : String,
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
        private var lastid: Int = 0
        fun makeUeser(fullName: String): User {
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User("${lastid++}", firstName, lastName)
        }
    }
}