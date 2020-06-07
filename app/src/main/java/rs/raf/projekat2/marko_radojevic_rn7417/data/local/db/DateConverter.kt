package rs.raf.projekat2.marko_radojevic_rn7417.data.local.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value:Long):Date{
        return Date(value)
    }

    @TypeConverter
    fun toTimestamp(date: Date):Long{
        return date.time
    }
}
