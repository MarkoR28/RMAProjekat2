package rs.raf.projekat2.marko_radojevic_rn7417.data.local.datasources

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.PredmetEntity

@Dao
abstract class PredmetDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insert(entity: PredmetEntity): Completable

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insertAll(entities: List<PredmetEntity>): Completable

    @Query("SELECT * FROM predmeti")
    abstract fun getAll(): Observable<List<PredmetEntity>>

    @Query("DELETE FROM predmeti")
    abstract fun deleteAll()

    @Transaction
    open fun deleteAndInsertAll(entities: List<PredmetEntity>) {
        deleteAll()
        insertAll(entities).blockingAwait()
    }

    @Query("SELECT * FROM predmeti WHERE nastavnik LIKE :name || '%' OR predmet LIKE :name || '%'" )
    abstract fun getByName(name: String): Observable<List<PredmetEntity>>

    @Query("SELECT * FROM predmeti WHERE (nastavnik LIKE :name || '%' OR predmet LIKE :name || '%') AND (grupe LIKE :grupa || '%') AND (dan LIKE :dan || '%')" )
    abstract fun getByNameAndAllParameters(name: String, grupa: String, dan: String): Observable<List<PredmetEntity>>


}