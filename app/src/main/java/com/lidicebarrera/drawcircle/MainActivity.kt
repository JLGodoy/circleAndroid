package com.lidicebarrera.drawcircle

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    var corx=0f  //variables que llevan la cuenta donde se va haciendo touch
    var cory=0f
    private lateinit var background:Canvass  //lateinit le dice que se va a inicializar mas tarde el codigo porque sino t pide que la inicialices


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val background = Canvass(this) //aqui ya la inicializamos
        cl.addView(background)

        background.setOnTouchListener{view,motionEvent->
            corx = motionEvent.x
            cory = motionEvent.y
            background.invalidate()
            true
        }
    }

    inner class Canvass(context: Context):View(context) {  //inner indica que es una clase interna

        override fun onDraw(canvas: Canvas) {
            canvas.drawRGB(255, 255, 0)
            val paint = Paint()
            paint.setARGB(255, 255, 0, 0)
            paint.setStrokeWidth(4f)
            paint.setStyle(Paint.Style.STROKE)  //solo el grosor, y si es .FILL rellena el circulo
            canvas.drawCircle(corx, cory, 20f, paint)
        }
    }
}
