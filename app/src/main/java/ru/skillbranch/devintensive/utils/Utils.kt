package ru.skillbranch.devintensive.utils

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

    /*
Реализуй метод Utils.transliteration(payload divider) принимающий в качестве аргумента строку (divider по умолчанию " ") и возвращающий преобразованную строку из латинских символов, словарь символов соответствия алфовитов доступен в ресурсах к заданию
Пример:
Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
Utils.transliteration("Amazing Петр","_") //Amazing_Petr
     */
    fun transliteration(payload: String, divider: String = " ") : String {
        val builder = StringBuilder()
        for (char in payload.trim())
            builder.append(replaceChar(char))
        return builder.toString().replace(" ", divider)
    }

    private fun replaceChar(char: Char) : String {
        val table = mapOf('а' to "a", 'б' to "b", 'в' to "v", 'г' to "g", 'д' to "d", 'е' to "e",
            'ё' to "e", 'ж' to "zh", 'з' to "z", 'и' to "i", 'й' to "i", 'к' to "k", 'л' to "l", 'м' to "m",
            'н' to "n", 'о' to "o", 'п' to "p", 'р' to "r", 'с' to "s",  'т' to "t", 'у' to "u", 'ф' to "f",
            'х' to "h", 'ц' to "c", 'ч' to "ch", 'ш' to "sh", 'щ' to "sh'", 'ъ' to "", 'ы' to "i", 'ь' to "",
            'э' to "e", 'ю' to "yu", 'я' to "ya"
        )
        val translit  = table[char.toLowerCase()] ?: char.toString()
        return if (char.isUpperCase() && translit.isNotEmpty()) translit.capitalize() else translit
    }
}