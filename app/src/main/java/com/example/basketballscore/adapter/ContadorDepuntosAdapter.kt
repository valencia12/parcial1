package com.example.basketballscore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basketballscore.R
import com.example.basketballscore.database.entities.ContadorP
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.banner.view.*

class ContadorDepuntosAdapter(): RecyclerView.Adapter<ContadorDepuntosAdapter.ViewHolder>(){
    private var countPoint = emptyList<ContadorP>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return countPoint.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = countPoint[position]
        holder.bind(current)
    }
    internal fun setCounterPoint(countPoint : List<ContadorP>){
        this.countPoint = countPoint
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: ContadorP) = with(itemView){
            tv_grupo1.text = item.grupo1
            tv_puntaje1.text = item.puntuacion1.toString()
            tv_puntajea.text = item.puntuacion2.toString()
            tv_grupo2.text = item.grupo2
            tv_fecha.text = item.date
            tv_ganador.text = item.ganador

        }
    }
}
