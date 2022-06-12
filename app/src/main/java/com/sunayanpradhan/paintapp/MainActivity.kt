package com.sunayanpradhan.paintapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.Window
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sunayanpradhan.paintapp.PaintView.Companion.colorList
import com.sunayanpradhan.paintapp.PaintView.Companion.paintStroke
import com.sunayanpradhan.paintapp.PaintView.Companion.pathList

class MainActivity : AppCompatActivity() {



    companion object{

        var path = Path()
        var paintBrush= Paint()

    }

    lateinit var colorRecyclerView: RecyclerView

    lateinit var erasePaint:CardView

    lateinit var editFont:CardView

    lateinit var colorArray:ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorRecyclerView= findViewById(R.id.color_recyclerView)
        erasePaint=findViewById(R.id.erase_paint)
        editFont=findViewById(R.id.edit_font)

        colorArray= ArrayList()

        colorArray.add(R.color.white)
        colorArray.add(R.color.card_purple)
        colorArray.add(R.color.card_yellow)
        colorArray.add(R.color.card_red)
        colorArray.add(R.color.card_violet)
        colorArray.add(R.color.card_blue)
        colorArray.add(R.color.card_green)
        colorArray.add(R.color.peach)
        colorArray.add(R.color.green)
        colorArray.add(R.color.purple)
        colorArray.add(R.color.darkPurple)
        colorArray.add(R.color.orangeRed)
        colorArray.add(R.color.yellowOrange)
        colorArray.add(R.color.MangoTango)
        colorArray.add(R.color.maizeCrayola)




        val adapter= SelectColorAdapter(colorArray,this)

        val layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        colorRecyclerView.layoutManager=layoutManager

        colorRecyclerView.adapter=adapter

        erasePaint.setOnClickListener {

            pathList.clear()
            colorList.clear()
            path.reset()

        }

        editFont.setOnClickListener {

            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

            dialog.setContentView(R.layout.paint_stroke_layout)

            val first: CardView? = dialog.findViewById(R.id.first)
            val second: CardView? = dialog.findViewById(R.id.second)
            val third: CardView? = dialog.findViewById(R.id.third)
            val fourth: CardView? = dialog.findViewById(R.id.fourth)
            val fifth: CardView? = dialog.findViewById(R.id.fifth)


            dialog.show()

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            first?.setOnClickListener {

                dialog.dismiss()

                paintStroke=5f
                paintBrush.strokeWidth= paintStroke



            }
            second?.setOnClickListener {

                dialog.dismiss()

                paintStroke=10f
                paintBrush.strokeWidth= paintStroke

            }
            third?.setOnClickListener {

                dialog.dismiss()

                paintStroke=15f
                paintBrush.strokeWidth= paintStroke

            }
            fourth?.setOnClickListener {

                dialog.dismiss()

                paintStroke=20f
                paintBrush.strokeWidth= paintStroke

            }
            fifth?.setOnClickListener {

                dialog.dismiss()

                paintStroke=25f
                paintBrush.strokeWidth= paintStroke

            }




        }




    }



}