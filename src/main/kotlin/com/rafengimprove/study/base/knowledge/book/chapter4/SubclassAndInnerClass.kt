package com.rafengimprove.study.base.knowledge.book.chapter4

import java.io.Serializable

interface State: Serializable

interface View {
    fun generateState(): State
    fun restoreState(state: State)
}

class Button3(): View {
    override fun generateState(): State = ButtonState()

    override fun restoreState(state: State) {

    }

    class ButtonState(): State {} // This is a subclass. It doesn't have a reference to the outer class.
    // ButtonState can be serialized because it's separate and doesn't hava a reference to the outer
    // class Button which implements View which is not serializable.

    // In Kotlin if we want the class to have reference to the outer class we need to add a word
    // 'inner'
}