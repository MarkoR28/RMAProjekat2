package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.rn7417.marko_radojevic_rn7417.R

import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.diff.BeleskeDiffCallback
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.viewHolder.BeleskeViewHolder

class BeleskeAdapter (beleskeDiffCallback: BeleskeDiffCallback, val onRemove: (BeleskaEntity)-> Unit, val onEdit: (BeleskaEntity)-> Unit,val onArhiva: (BeleskaEntity)-> Unit) : ListAdapter<BeleskaEntity, BeleskeViewHolder>(beleskeDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeleskeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_beleska_list_item,parent,false)
        return BeleskeViewHolder(
            containerView,
            {
                val beleska = getItem(it)
                onRemove(beleska)
            },
            {
                val beleska = getItem(it)
                onEdit(beleska)
            },
            {
                val beleska = getItem(it)
                onArhiva(beleska)
            }
        )
    }

    override fun onBindViewHolder(holder: BeleskeViewHolder, position: Int) {
        val beleska = getItem(position)
        holder.bind(beleska)
    }


}