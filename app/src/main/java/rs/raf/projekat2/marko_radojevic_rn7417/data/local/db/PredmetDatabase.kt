package rs.raf.projekat2.marko_radojevic_rn7417.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.datasources.PredmetDao
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.PredmetEntity

@Database(
    entities = [PredmetEntity::class],
    version = 2,
    exportSchema = false)
@TypeConverters()
abstract class PredmetDataBase : RoomDatabase() {
    abstract fun getPredmetDao(): PredmetDao
}