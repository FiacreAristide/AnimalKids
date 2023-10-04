package tg.aristide.animalkids

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private var animalList: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_animal,
            parent,
            false
        )
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val currentAnimal = animalList[position]

        // Personnalisez les éléments de l'élément d'animal en fonction des données de currentAnimal
        holder.itemView.findViewById<TextView>(R.id.animalName).text = currentAnimal.name
        holder.itemView.findViewById<TextView>(R.id.animalDescription).text = currentAnimal.description
        holder.itemView.findViewById<ImageView>(R.id.animalImage).setImageResource(currentAnimal.imageResId)

    }

    override fun getItemCount(): Int {
        return animalList.size
    }



}
