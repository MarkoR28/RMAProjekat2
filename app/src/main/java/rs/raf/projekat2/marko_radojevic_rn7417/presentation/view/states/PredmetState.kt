package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.states

import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Predmet

sealed class PredmetState {
    object Loading: PredmetState()
    object DataFetched: PredmetState()
    data class Success(val predmeti: List<Predmet>): PredmetState()
    data class Error(val message: String): PredmetState()
}