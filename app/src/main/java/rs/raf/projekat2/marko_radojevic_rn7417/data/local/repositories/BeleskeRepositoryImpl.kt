package rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.datasources.BeleskaDao
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity
import java.util.*

class BeleskeRepositoryImpl(private val beleskaDao: BeleskaDao ) : BeleskeRepository{

    override fun insert(beleskaEntity: BeleskaEntity): Completable {
        return beleskaDao.insert(beleskaEntity)
    }
    override fun getAll(): Observable<List<BeleskaEntity>> {
        return beleskaDao.getAll()
    }

    override fun updateById(id: Long, naziv: String, zapis:String): Completable {
        return beleskaDao.updateById(id, naziv,zapis)
    }

    override fun deleteById(id: Long): Completable {
        return beleskaDao.deleteById(id)
    }

    override fun changeArhiva(id: Long, arhiva: Boolean): Completable {
        return beleskaDao.changeArhiva(id,arhiva)
    }

    override fun getBySerach(search: String): Observable<List<BeleskaEntity>> {
        return beleskaDao.getSearchBeleska(search)
    }

    override fun getBySwitch(switch: Boolean): Observable<List<BeleskaEntity>> {
        return beleskaDao.getSwitchBeleska(switch)
    }
    override fun getByDate(date: Date): Observable<List<BeleskaEntity>> {
        return beleskaDao.getByDate(date)
    }

}