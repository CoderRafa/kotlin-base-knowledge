package com.rafengimprove.study.base.knowledge.book.chapter3

class User(val id: Int, val name: String, val address: String) {

    fun saveUser(user: User) {
        if (user.name.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Name"
            )
        }

        if (user.address.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Address"
            )
        }

    }

}
// This code is not good because it has repeating parts
// Now let's do the same with a local function

class User1(val id: Int, val name: String, val address: String) {

    fun saveUser(user: User) {
        fun validate(
            user: User,
            value: String,
            fieldName: String
        ) {
            if (value.isEmpty()) {
                throw IllegalArgumentException(
                    "Can't save user ${user.id} - Empty $fieldName"
                )
            }

            validate(user, user.name, "Name")
            validate(user, user.address, "Address")
        }
    }
}

// inner or local functions have access to all the parameters of the parent function
// that's why we can do this

class User2(val id: Int, val name: String, val address: String) {

    fun saveUser(user: User) {
        fun validate(
            value: String,
            fieldName: String
        ) {
            if (value.isEmpty()) {
                throw IllegalArgumentException(
                    "Can't save user ${user.id} - Empty $fieldName"
                )
            }

            validate(user.name, "Name")
            validate(user.address, "Address")
        }
    }
}

// also we can make the function extension function

class User3(val id: Int, val name: String, val address: String) {

    fun User.validateBeforeUser(user: User) {
        fun validate(
            value: String,
            fieldName: String
        ) {
            if (value.isEmpty()) {
                throw IllegalArgumentException(
                    "Can't save user ${user.id} - Empty $fieldName"
                )
            }

            validate(user.name, "Name")
            validate(user.address, "Address")
        }
    }
}