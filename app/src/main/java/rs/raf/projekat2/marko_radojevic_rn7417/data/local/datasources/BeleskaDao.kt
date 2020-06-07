package rs.raf.projekat2.marko_radojevic_rn7417.data.local.datasources

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity
import java.util.*

@Dao
abstract class BeleskaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(beleskaEntity: BeleskaEntity) :Completable

    @Query("SELECT * FROM beleske")
    abstract fun getAll(): Observable<List<BeleskaEntity>>

    @Query("UPDATE beleske SET naziv = :naziv  ,zapis = :zapis WHERE id == :id")
    abstract fun updateById(id: Long, naziv: String, zapis: String): Completable

    @Query("UPDATE beleske SET arhiva = :arhiva WHERE id == :id")
    abstract fun changeArhiva(id: Long, arhiva:Boolean): Completable


    @Query("DELETE FROM beleske WHERE id == :id")
    abstract fun deleteById(id: Long): Completable

    @Query("SELECT * FROM beleske WHERE naziv LIKE :search || '%'  OR zapis LIKE :search || '%' ")
    abstract fun getSearchBeleska(search: String): Observable<List<BeleskaEntity>>

    @Query("SELECT * FROM beleske WHERE arhiva = :switch ")
    abstract fun getSwitchBeleska(switch: Boolean): Observable<List<BeleskaEntity>>

    @Query("SELECT * FROM beleske WHERE dateOfCreate == :createDate")
    abstract fun getByDate(createDate: Date): Observable<List<BeleskaEntity>>


}