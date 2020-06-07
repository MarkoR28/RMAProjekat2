package rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Predmet
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Resource

interface PredmetRepository {

    fun fetchAll(): Observable<Resource<Unit>>
    fun getAll(): Observable<List<Predmet>>
    fun getAllByName(name: String): Observable<List<Predmet>>
    fun insert(predmet: Predmet): Completable
    fun getByParameters(name: String, grupa: String, dan: String): Observable<List<Predmet>>

}