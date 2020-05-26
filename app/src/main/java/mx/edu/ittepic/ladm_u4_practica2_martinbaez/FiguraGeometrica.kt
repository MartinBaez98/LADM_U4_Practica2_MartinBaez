package mx.edu.ittepic.ladm_u4_practica2_martinbaez

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint

class FiguraGeometrica () {
    var x = 0f
    var y = 0f
    var tipo = 1
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incX = 2
    var incY = 5
    var imagen : Bitmap ?= null

    constructor(x:Int, y:Int, radio:Int) : this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio = radio.toFloat()
    }

    constructor(x:Int, y:Int, ancho:Int, alto:Int) : this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.ancho = ancho.toFloat()
        this.alto = alto.toFloat()
        tipo = 2
    }

    constructor(bitmap: Bitmap, x:Int, y:Int):this(){
        imagen = bitmap
        this.x = x.toFloat()
        this.y = y.toFloat()
        tipo = 3
        ancho = imagen!!.width.toFloat()
        alto = imagen!!.height.toFloat()
    }

    fun pintar(c: Canvas, p: Paint){
        when(tipo){
            1->{
                c.drawCircle(x,y,radio,p)
            }
            2->{
                c.drawRect(x,y,x+ancho,y+alto,p)
            }
            3->{
                c.drawBitmap(imagen!!,x,y,p)
            }
        }
    }

    fun correrDer(){
        if(x >= 900){
            x += 0
        }else {
            x += incX
        }
    }

    fun correrIzq(){
        if(x <= -20){
            x -= 0
        }else {
            x -= incX
        }
    }

    fun cambiarImagen(img: Bitmap){
        imagen = img
    }

}