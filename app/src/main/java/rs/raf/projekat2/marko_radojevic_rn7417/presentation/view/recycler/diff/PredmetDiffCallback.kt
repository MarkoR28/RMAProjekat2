package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Predmet

class PredmetDiffCallback : DiffUtil.ItemCallback<Predmet>() {

    override fun areItemsTheSame(oldItem: Predmet, newItem: Predmet): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Predmet, newItem: Predmet): Boolean {
        return oldItem.predmet == newItem.predmet
    }

}