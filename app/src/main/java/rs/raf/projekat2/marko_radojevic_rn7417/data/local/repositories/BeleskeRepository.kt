package rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories

import androidx.room.ColumnInfo
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity
import java.util.*

interface BeleskeRepository {
       fun insert(beleskaEntity: BeleskaEntity):Completable
    fun getAll(): Observable<List<BeleskaEntity>>

    fun updateById(id: Long, naziv: String, zapis:String): Completable
    fun deleteById(id: Long): Completable
    fun changeArhiva(id: Long, arhiva: Boolean): Completable
    fun getBySerach(search: String): Observable<List<BeleskaEntity>>
    fun getBySwitch(switch: Boolean): Observable<List<BeleskaEntity>>
    fun getByDate(date: Date): Observable<List<BeleskaEntity>>

}