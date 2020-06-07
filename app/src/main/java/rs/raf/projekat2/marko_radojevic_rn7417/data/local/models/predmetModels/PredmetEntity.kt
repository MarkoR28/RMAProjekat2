package rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "predmeti")
data class PredmetEntity(
    @PrimaryKey val id: String,
    val predmet: String,
    val tip: String,
    val nastavnik: String,
    val grupe: String,
    val dan: String,
    val termin: String,
    val ucionica: String
)