package rs.raf.projekat2.marko_radojevic_rn7417.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.datasources.BeleskaDao
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity

@Database(
    entities = [BeleskaEntity::class],
    version = 3,
    exportSchema = false
)

@TypeConverters(DateConverter::class)
abstract class BeleskaDatabase : RoomDatabase() {
    abstract fun getBeleskaDao() : BeleskaDao
}

