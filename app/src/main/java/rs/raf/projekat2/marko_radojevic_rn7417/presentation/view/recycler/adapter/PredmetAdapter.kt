package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.rn7417.marko_radojevic_rn7417.R
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Predmet
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.diff.PredmetDiffCallback
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.viewHolder.PredmetViewHolder

class PredmetAdapter : ListAdapter<Predmet, PredmetViewHolder>(PredmetDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PredmetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_predmet_list_item, parent, false)
        return PredmetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PredmetViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}