package com.rafengimprove.study.base.knowledge.book.chapter7

// if the initialization of a property is a heavy operation it's good to initialize
// only when it's needed and save its value to use afterward

// for example, we have a list of emails in the database, and we have to load them for a person

class Email {/*...*/ }
fun loadEmails(person: PersonLazyInit): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(/*...*/)
}

// for lazy initialization we have to do this

class PersonLazyInit(val name: String) {
    private var _emails: List<Email>? = null

    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this) // if data hasn't been loaded then load it
            }
            return _emails!! // if it has been loaded return it
        }
}
// here we use so-called backing property, '_emails' can be null but 'emails' can't.

// the better way of doing this is using 'by Lazy' from the standard library

class PersonByLazy(val name: String) {
    val emails by lazy { loadEmails(this) }
}

fun loadEmails(person: PersonByLazy): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(/*...*/)
}

