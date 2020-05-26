package mx.edu.ittepic.ladm_u4_practica2_martinbaez

import android.graphics.*
import android.view.MotionEvent
import android.view.View

class Lienzo(p: MainActivity) : View(p) {
    var puntero = p
    /*Personajes y fondos*/
    var luffyDer = BitmapFactory.decodeResource(resources, R.drawable.luffy_der)
    var luffyIzq = BitmapFactory.decodeResource(resources, R.drawable.luffy_izq)
    var luffy = BitmapFactory.decodeResource(resources, R.drawable.luffy)
    var personaje = FiguraGeometrica(luffy, 800 , 1200)
    var fondo1 = BitmapFactory.decodeResource(resources, R.drawable.b21c653d5cabdb2dec4806c5308d28de)
    var fondo2 = BitmapFactory.decodeResource(resources, R.drawable.descarga)
    var back = FiguraGeometrica(fondo1, 0, 0)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        back.pintar(canvas, paint)
        personaje.pintar(canvas, paint)
    }


    fun movimientos(){
        fondos()
        if(puntero.coorX < 0){
            personaje.cambiarImagen(luffyDer)
            personaje.correrDer()
        }
        if(puntero.coorX > 0){
            personaje.cambiarImagen(luffyIzq)
            personaje.correrIzq()
        }
        invalidate()
    }

    fun fondos(){
        if(puntero.cambio > 0){
            back.cambiarImagen(fondo1)
        }else{
            back.cambiarImagen(fondo2)
        }
    }

}