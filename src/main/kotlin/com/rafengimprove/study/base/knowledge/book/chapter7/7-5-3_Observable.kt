package com.rafengimprove.study.base.knowledge.book.chapter7

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// we can use delegation to process property change events
// to do it without standard library functions we have to use PropertyChangeSupport

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class PersonListener(val name: String, age: Int, salary: Int): PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

// to avoid repeating code let's create another class
class ObservableProperty(
    val propName: String, var propValue: Int, val changeSupport: PropertyChangeSupport
) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class PersonManuallyObservable(val name: String, age: Int, salary: Int): PropertyChangeAware() {
    val _age = ObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(value) { _age.setValue(value) }

    val _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value) { _salary.setValue(value) }
}

// now let's write ObservableProperty close to delegate
class ObservablePropertyDelegate(var propValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(p: PersonObservablePropertyDelegate, prop: KProperty<*>): Int = propValue

    operator fun setValue(p: PersonObservablePropertyDelegate, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class PersonObservablePropertyDelegate(val name: String, age: Int, salary: Int): PropertyChangeAware() {
    var age: Int by ObservablePropertyDelegate(age, changeSupport)
    var salary: Int by ObservablePropertyDelegate(salary, changeSupport)
}

// Define an observable property using Delegates.observable
var myValue: String by Delegates.observable("Initial Value") { _, oldValue, newValue ->
    println("Value changed from $oldValue to $newValue")
    // Additional actions can be performed here based on the change
}

fun main() {
    val p = PersonListener("Dmitry", 34, 2000)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }
    )

    p.age = 35
    p.salary = 2100

    val pMO = PersonManuallyObservable("Olesya", 27, 3000)
    pMO.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }
    )

    pMO.age = 26

    // Modifying the property will trigger the observer block
    myValue = "New Value"
    myValue = "Another Value"
}