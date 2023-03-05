package ru.startandroid.develop.layoutinflaterlist

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar.LayoutParams

class MainActivity : AppCompatActivity() {

    private var name = arrayOf("Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
        "Костя", "Игорь")

    private var position = arrayOf("Программер", "Бухгалтер", "Программер",
        "Программер", "Бухгалтер", "Директор", "Программер", "Охранник")

    private var salary = arrayOf(13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000)

    private var color = IntArray(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        color[0] = Color.parseColor("#559966CC")
        color[1] = Color.parseColor("#55336699")

        val linLayout = findViewById<LinearLayout>(R.id.linLayout)
        val ltInflater = layoutInflater

        for (i in name.indices) {
            Log.d("myLogs", "i = $i")
            val item = ltInflater.inflate(R.layout.item, linLayout, false)
            val tvName = item.findViewById<TextView>(R.id.tvName)
            tvName.text = name[i]
            val tvPosition = item.findViewById<TextView>(R.id.tvPosition)
            tvPosition.setText("Должность + ${position[i]}")
            val tvSalary = item.findViewById<TextView>(R.id.tvSalary)
            tvSalary.setText("Оклад + ${salary[i]}")
            item.layoutParams.width = LayoutParams.MATCH_PARENT
            item.setBackgroundColor(color[i % 2])
            linLayout.addView(item)
        }
    }
}