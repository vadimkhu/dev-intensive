package ru.skillbranch.devintensive.extensions

/*
Реализуй extension позволяющий очистить строку от html тегов и html escape последовательностей
 ("& < > ' ""), а так же удалить пустые символы (пробелы) между словами если их больше 1.
 Необходимо вернуть модифицированную строку

Пример:
"<p class="title">Образовательное IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
"<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
 */
fun String.stripHtml(): String {
    return this.replace(Regex("(<[^<>]+>)|(&[^ а-я]{1,4}?;)", "").replace(Regex("( {2,})"), " ")
}

/*
Реализуй extension усекающий исходную строку до указанного числа символов (по умолчанию 16) и возвращающий усеченную строку с заполнителем "..." (если строка была усечена) если последний символ усеченной строки является пробелом - удалить его и добавить заполнитель
Пример:
"Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate() //Bender Bending R...
"Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15) //Bender Bending...
"A     ".truncate(3) //A
 */
fun String.truncate(length: Int = 16): String {
    val trimmed = this.trim()
    return if (trimmed.length <= length) trimmed else trimmed.substring(0, length).trim() + "..."
}
