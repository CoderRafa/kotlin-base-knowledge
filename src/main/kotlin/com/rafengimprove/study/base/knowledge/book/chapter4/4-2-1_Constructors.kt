package com.rafengimprove.study.base.knowledge.book.chapter4


// when you inherit a class you should initialize its properties

open class User1(val nickname: String) {}

class TwitterUser(nickname: String): User1(nickname) {}

// you can have a class without a constructor. In that case the compiler will add a default constructor.
// if you want to inherit(extend) this class you should explicitly call its constructor

open class Button2

class RadioButton: Button2()
class RadioButton1(): Button2()

// if you want to make sure that no instances of the class can be created make the constructor private

class Secretive private constructor()

// if a class that you want to inherit doesn't have a primary constructor and has only secondary
// constructor or constructors you should declare its constructors

open class View1 {
    constructor(ctx: Con) {

    }

    constructor(ctx: Con, style: Style)
}

class myButton: View1 {
    constructor(ctx: Con): super(ctx) {

    }

    constructor(ctx: Con, style: Style): super(ctx, style)
}

// here we delegate the constructor implementation to the super class
// you can also delegate the constructor implementation to another class

class MyButtonDelegated: View1 {
    constructor(ctx: Con, ): this(ctx, Style("Hello"))

    constructor(ctx: Con, style: Style): super(ctx, style)
}

class Style(val hello: String) {}

class Con(val hello: String) {}