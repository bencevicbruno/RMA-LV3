package ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rma_lv2.R
import com.example.rma_lv2.databinding.ItemBirdBinding
import model.Bird

class BirdAdapter: RecyclerView.Adapter<BirdViewHolder>() {

    val birds = mutableListOf<Bird>()
    var onBirdSelected: BirdSelectListener? = null

    fun setBirds(birds: List<Bird>) {
        this.birds.clear()
        this.birds.addAll(birds)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bird, parent, false)
        return BirdViewHolder(view)
    }

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        val bird = birds[position]
        holder.bind(bird)
        onBirdSelected?.let { listener ->
            holder.itemView.setOnClickListener { listener.onBirdLongPress(bird) }
        }

    }

    override fun getItemCount(): Int {
        print(birds.count())
        return birds.count()
    }
}

class BirdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(bird: Bird) {
        val binding = ItemBirdBinding.bind(itemView)
        binding.itemBirdName.text = "${bird.name} colored: ${bird.color} seen at: ${bird.location}"
    }
}