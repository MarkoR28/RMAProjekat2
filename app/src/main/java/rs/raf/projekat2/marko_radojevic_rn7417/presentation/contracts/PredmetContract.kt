package rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Predmet
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.SpinnerFilter
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.states.PredmetState

interface PredmetContract {

    interface ViewModel {

        val predmetState: LiveData<PredmetState>

        fun fetchAllPredmeti()
        fun getAllPredmeti()
        fun getPredmetByName(filter: SpinnerFilter)
        fun addPredmet(predmet: Predmet)

    }
    interface UserViewModel{
        fun validate(pin1: Int,pin2: Int, pin3: Int, pin4: Int, username: String): Boolean
    }

}