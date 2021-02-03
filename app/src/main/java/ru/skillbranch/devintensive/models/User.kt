package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
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
            return User(
                "${lastid++}",
                firstName,
                lastName
            )
        }
    }

    class Builder {
        var id : String = ""
        var firstName : String? = null
        var lastName : String? = null
        var avatar : String? = null
        var rating : Int = 0
        var respect : Int = 0
        var lastVisit : Date? = Date()
        var isOnline : Boolean = false

        fun id(id: String) = apply { this.id = id }

        fun firstName(firstName: String?) = apply { this.firstName = firstName }

        fun lastName(lastName: String?)= apply { this.lastName = lastName }

        fun avatar(avatar: String?)= apply { this.avatar = avatar }

        fun rating(rating: Int)= apply { this.rating = rating }

        fun respect(respect: Int)= apply { this.respect = respect }

        fun lastVisit(lastVisit: Date?)= apply { this.lastVisit = lastVisit }

        fun isOnline(isOnline: Boolean)= apply { this.isOnline = isOnline }

        fun build() = User(
            id,
            firstName,
            lastName,
            avatar,
            rating,
            respect,
            lastVisit,
            isOnline
        )
    }
}