package com.example.basketballscore.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basketballscore.R
import com.example.basketballscore.adapter.ContadorDepuntosAdapter
import com.example.basketballscore.database.viewmodel.puntosViewModel
import kotlinx.android.synthetic.main.activity_fragment_historial.view.*

class FragmentHistorialPartidas : Fragment() {
     lateinit var puntosViewModel1: puntosViewModel
     lateinit var ContadorAdapter:ContadorDepuntosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_fragment_historial, container, false)
        puntosViewModel1 = ViewModelProviders.of(this).get(puntosViewModel::class.java)
        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view: View) {
        val linearLayoutManager = LinearLayoutManager(this.context)
        ContadorAdapter = ContadorDepuntosAdapter()
        view.historial_rv.adapter = ContadorAdapter

        puntosViewModel1.part.observe(this, Observer { countPoint->
            countPoint?.let { ContadorAdapter.setCounterPoint(it) }
        })

        view.historial_rv.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
        }
    }
    companion object {
        fun newInstance(): FragmentHistorialPartidas{
            val newFragment = FragmentHistorialPartidas()
            return newFragment
        }
    }
}
