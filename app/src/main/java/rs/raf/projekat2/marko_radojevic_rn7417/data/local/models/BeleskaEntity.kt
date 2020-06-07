package rs.raf.projekat2.marko_radojevic_rn7417.data.local.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import org.jetbrains.annotations.NotNull
import java.util.*

@Parcelize
@Entity(tableName = "beleske")
data class BeleskaEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val naziv:String?,
    val zapis:String?,
    val arhiva:Boolean,
    @ColumnInfo(name = "dateOfCreate")var dateOfCreate: Date = Date()
): Parcelable
