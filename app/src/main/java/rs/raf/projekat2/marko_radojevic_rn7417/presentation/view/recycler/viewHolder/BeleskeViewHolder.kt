package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_beleska_list_item.*


class BeleskeViewHolder(override val containerView: View, onRemove: (Int)->Unit, onEdit: (Int)->Unit,onArhiva: (Int)->Unit): RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {

        removeBtn.setOnClickListener {
            val position = adapterPosition
            onRemove(position)
        }
        editBtn.setOnClickListener {
            val position = adapterPosition
            onEdit(position)
        }
        archiveBtn.setOnClickListener {
            val position = adapterPosition
            onArhiva(position)
        }
    }

    fun bind(beleskaEntity: BeleskaEntity){
        nazivBeleskeTxt.text=beleskaEntity.naziv
        textBeleskeTxt.text=beleskaEntity.zapis
    }

}