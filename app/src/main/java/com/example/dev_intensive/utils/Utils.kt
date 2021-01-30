package com.example.dev_intensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts = fullName?.trim()?.split(" ")
        val firstName = parts?.getOrNull(0)?.ifEmpty { null }
        val secondName = parts?.getOrNull(1)?.ifEmpty { null }
        return firstName to secondName
    }

    fun toInitials(firstName: String?, lastName: String?) : String? {
        val name = firstName.orEmpty().trim().getOrNull(0)?.toUpperCase()
        val last = lastName.orEmpty().trim().getOrNull(0)?.toUpperCase()
        val nameInit = name?.toString() ?: ""
        val lastInit = last?.toString() ?: ""
        return "$nameInit$lastInit".ifEmpty { null }
    }
}