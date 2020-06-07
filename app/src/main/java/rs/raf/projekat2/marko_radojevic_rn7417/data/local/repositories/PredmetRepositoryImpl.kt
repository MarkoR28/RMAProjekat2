package rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.datasources.PredmetDao
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.datasources.PredmetService
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Predmet
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.PredmetEntity
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Resource
import timber.log.Timber

class PredmetRepositoryImpl(
    private val localDataSource: PredmetDao,
    private val remoteDataSource: PredmetService
) : PredmetRepository {

    override fun fetchAll(): Observable<Resource<Unit>> {
        return remoteDataSource
            .getAll()
            .doOnNext {
                Timber.e("Upis u bazu")
                val entities = it.map {
                    PredmetEntity(
                        it.predmet+"-"+it.termin, it.predmet, it.tip, it.nastavnik, it.grupe, it.dan, it.termin, it.ucionica
                    )
                }
                localDataSource.deleteAndInsertAll(entities)
            }
            .map {
                Resource.Success(Unit)
            }
        // Kada zelimo sami da kontrolisemo sta se desava sa greskom, umesto da je samo prepustimo
        // error handleru, mozemo iskoristiti operator onErrorReturn, tada sami na osnovu greske
        // odlucujemo koju vrednost cemo da vratimo. Ta vrednost mora biti u skladu sa povratnom
        // vrednoscu lanca.
        // Kada se iskoristi onErrorReturn onError lambda u viewmodelu nece biti izvrsena,
        // nego ce umesdto nje biti izvsena onNext koja ce kao parametar primiti vrednost koja
        // je vracena iz onErrorReturn
        // Obicno se koristi kada je potrebno proveriti koji kod greske je vratio server.
//            .onErrorReturn {
//                when(it) {
//                    is HttpException -> {
//                        when(it.code()) {
//                            in 400..499 -> {
//
//                            }
//                        }
//                    }
//                }
//                Timber.e("ON ERROR RETURN")
//            }
    }

    override fun getAll(): Observable<List<Predmet>> {
        return localDataSource
            .getAll()
            .map {
                it.map {
                    Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.grupe, it.dan, it.termin, it.ucionica)
                }
            }
    }

    override fun getAllByName(name: String): Observable<List<Predmet>> {
        return localDataSource
            .getByName(name)
            .map {
                it.map {
                    Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.grupe, it.dan, it.termin, it.ucionica)
                }
            }
    }

    override fun insert(predmet: Predmet): Completable {
        val predmetEntity = PredmetEntity(predmet.id, predmet.predmet, predmet.tip, predmet.nastavnik, predmet.grupe, predmet.dan, predmet.termin, predmet.ucionica)
        return localDataSource
            .insert(predmetEntity)
    }

    override fun getByParameters(
        name: String,
        grupa: String,
        dan: String
    ): Observable<List<Predmet>> {
        println("Grupa - " + grupa) //SRE
        println("Dan - " + dan) //102
        var grupa2: String
        var dan2: String
        if (grupa == "Dan") {
            dan2 = ""
        }
        else{
            dan2 = grupa
        }
        if(dan == "Grupa"){
            grupa2 = ""
        }
        else
        {
            grupa2 = dan
        }

        println(dan2)
        println(grupa2)
        return localDataSource
            .getByNameAndAllParameters(name, grupa2, dan2)
            .map {
                it.map {
                    Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.grupe, it.dan, it.termin, it.ucionica)
                }
            }
    }

}