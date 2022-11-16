package com.example.discoapp.authentication



class User{
    var name: String
    get() = field
    set(value) { field = value}

    var surname: String
        get() =field
        set(value) { field = value }
/*
    var cell_number: String
        get() = field
        set(value) { field = value }
*/
    var email:String
        get() = field
        set(value) { field = value }

    constructor() : this("","","")
    constructor(name: String, surname: String, email:String) {
        this.name =  name
        //this.cell_number = cell_number
        this.surname = surname
        this.email = email

    }
}
