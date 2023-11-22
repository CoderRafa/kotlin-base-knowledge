package com.rafengimprove.study.base.knowledge.book.chapter4

interface Clickable {
    fun click()
}

class Button(): Clickable {
    override fun click() {
        println("I was clicked")
    }
}

interface ClickableDefault {
    fun click()
    fun showOff() = println("I am clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) {
        println("I ${if(b) "got" else "lost"} focus")
    }

    fun showOff() = println("I am focusable")
}

// two interfaces have the same default method
// if a class implements both interfaces the compiler will not know
// which default method to use and will show an error that we have to
// override the method or mention from which interface we would like to
// use the default method
class Button1(): ClickableDefault, Focusable {
    override fun click() {
        println("I was clicked")
    }

//    override fun showOff() {
//        super<ClickableDefault>.showOff()
//    }

    override fun showOff() {
        println("showOff was overridden")
    }
}

// in order to inherit a class we should make it open
open class RichButton(): ClickableDefault { // other classes can inherit this class
    fun disable() {} // this is a closed method, it can't be overridden in child classes

    open fun animate() {} // this method can be overridden

    override fun click() { // overridden method from an interface is also open and can be overridden in
                           // child class. To prevent this you should put 'final' at the beginning
        println("I was clicked")
    }
}