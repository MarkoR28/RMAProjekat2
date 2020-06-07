package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_predmet_list_item.*
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Predmet

class   PredmetViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(predmet: Predmet) {
        predmetTv.text = predmet.predmet
        profesorTv.text = predmet.nastavnik
        ucionicaTv.text = predmet.ucionica
        grupeTv.text = predmet.grupe
        vremeTv.text = predmet.dan + " - " + predmet.termin
    }

}