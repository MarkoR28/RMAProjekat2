package rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels

data class PredmetResponse(
    val id: String,
    val predmet: String,
    val tip: String,
    val nastavnik: String,
    val grupe: String,
    val dan: String,
    val termin: String,
    val ucionica: String
)