package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity

class BeleskeDiffCallback : DiffUtil.ItemCallback<BeleskaEntity>() {

    override fun areItemsTheSame(oldItem: BeleskaEntity, newItem: BeleskaEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BeleskaEntity, newItem: BeleskaEntity): Boolean {
        return oldItem.naziv == newItem.naziv && oldItem.zapis==newItem.zapis
    }

}