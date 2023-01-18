package com.example.practica17.model

class Alumno: java.io.Serializable {
    var name:String=""
    var apellido:String=""
    var DNI:String=""
    var isImage = false
    var text: String? = null
    var imageId = 0

    constructor()
    constructor(
        name: String,
        apellido: String,
        DNI: String,
        isImage: Boolean,
        text: String?,
        imageId: Int
    ) {
        this.name = name
        this.apellido = apellido
        this.DNI = DNI
        this.isImage = isImage
        this.text = text
        this.imageId = imageId
    }

    constructor(name: String, apellido: String, DNI: String, text: String?) {
        this.name = name
        this.apellido = apellido
        this.DNI = DNI
        this.text = text
    }

    constructor(name: String, apellido: String, DNI: String, imageId: Int) {
        this.name = name
        this.apellido = apellido
        this.DNI = DNI
        this.imageId = imageId
    }

    override fun toString(): String {
        return name
    }



}