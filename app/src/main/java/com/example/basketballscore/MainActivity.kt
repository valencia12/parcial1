package com.example.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import com.example.basketballscore.database.entities.ContadorP
import com.example.basketballscore.database.viewmodel.puntosViewModel
import com.example.basketballscore.fragmentos.FragmentHistorialPartidas
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : puntosViewModel
    private lateinit var fragment : FragmentHistorialPartidas
    val calendar: Calendar = java.util.Calendar.getInstance()
    val format = SimpleDateFormat("dd/MM/yyyy h:mm a")
    var coun1 : Int = 0
    var coun2 : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(puntosViewModel::class.java)
        fragment = FragmentHistorialPartidas.newInstance()
        val scoreAObserver = Observer<Int>{ newValueA ->
            tv_puntaje1.text = newValueA.toString()
        }
        val scoreBObserver = Observer<Int> { newValueB ->
            tv_puntaje2.text = newValueB.toString()
        }
        viewModel.puntuacion1.observe(this, scoreAObserver)
        viewModel.puntuacion2.observe(this,scoreBObserver)
        val btnGuardar = findViewById<Button>(R.id.a)
        btnGuardar.setOnClickListener { click() }
        a.setOnClickListener {
            changeFragment(R.id.main1, fragment)
        }
        // TEAM A
        grupo1_3.setOnClickListener {
            coun1 +=3
            viewModel.puntuacion1.value = coun1
        }

        grupo1_2.setOnClickListener {
            coun1 +=2
            viewModel.puntuacion1.value = coun1
        }
        grupo1_1.setOnClickListener {
            coun1++
            viewModel.puntuacion1.value = coun1
        }

        // TEAM B
        grupo2_3.setOnClickListener {
            coun2 +=3
            viewModel.puntuacion2.value = coun2
        }

        grupo2_2.setOnClickListener {
            coun2 +=2
            viewModel.puntuacion2.value = coun2
        }
        grupo2_1.setOnClickListener {
            coun2++
            viewModel.puntuacion2.value = coun2
        }
    }
    fun click(){
        if(TextUtils.isEmpty(et_grupo1.text) && TextUtils.isEmpty(et_grupo2.text)){
            Toast.makeText(applicationContext, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }else{
            var teamA = et_grupo1.text.toString()
            var teamB = et_grupo2.text.toString()
            var scoreA = tv_puntaje1.text.toString()
            var scoreB = tv_puntaje2.text.toString()
            var winner:String

            winner = if(scoreA.toInt() > scoreB.toInt()){
                teamA
            }else{
                teamB
            }
            var completar = "Fecha: " + format.format(calendar.time)
            var play = ContadorP(teamA, teamB, scoreA.toInt(), scoreB.toInt(), completar, "5:12", winner)

            viewModel.insert(play)
            Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_LONG).show()
        }
    }


    private fun changeFragment(id: Int, frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }
}
