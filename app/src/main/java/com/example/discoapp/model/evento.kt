package com.example.discoapp.model
//
class evento {
    var id: String? = null
    var luogo: String? = null
    var data: String? = null
    var posti: String? = null
    var description: String? = null


    constructor(  id:String,  luogo:String,
                  data:String,  posti:String, description:String){
        this.id = id
        this.luogo = luogo
        this.data = data
        this.posti = posti

        this.description = description
    }
    constructor()

}

