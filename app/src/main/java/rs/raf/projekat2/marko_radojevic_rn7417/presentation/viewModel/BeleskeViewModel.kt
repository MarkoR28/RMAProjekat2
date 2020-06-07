package rs.raf.projekat2.marko_radojevic_rn7417.presentation .viewModel

 import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.BeleskeRepository
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts.BeleskaContract
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity
import timber.log.Timber
 import java.util.*

class BeleskeViewModel(private val beleskeRepository: BeleskeRepository) : ViewModel(), BeleskaContract.ViewModel {

    private val beleska: MutableLiveData<List<BeleskaEntity>> = MutableLiveData()
    private val beleskaList :MutableList<BeleskaEntity> = mutableListOf()
    private val subscriptions = CompositeDisposable()

    override fun insertBeleska(beleskaEntity: BeleskaEntity) {
        val subscription = beleskeRepository
            .insert(beleskaEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("INSERT VIEW MODEL COMPLETE")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }


    override fun getAllBeleske() {
        val subscription = beleskeRepository.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.forEach{ beleskaList.add(it) }
                    val listToSubmit0 = mutableListOf<BeleskaEntity>()
                    listToSubmit0.addAll(beleskaList)
                    beleskaList.clear()
                    beleska.value=listToSubmit0
                },
                {
                    Timber.e(it) },
                {
                    Timber.e("Uspesno preuzete beleske")
                }
            )
        subscriptions.add(subscription)
    }

    override fun getListBeleska() : LiveData<List<BeleskaEntity>>{
        return beleska
    }

    override fun updateByIdBeleska(beleskaEntity: BeleskaEntity) {
        val subscription = beleskeRepository
            .updateById(beleskaEntity.id, beleskaEntity.naziv.toString(), beleskaEntity.zapis.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("UPDATE VIEW MODEL COMPLETE")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun removeByIdBeleska(beleskaEntity: BeleskaEntity) {
        val subscription = beleskeRepository
            .deleteById(beleskaEntity.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("REMOVE VIEW MODEL COMPLETE")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun changeArhivaBeleska(beleskaEntity: BeleskaEntity) {
        val subscription = beleskeRepository
            .changeArhiva(beleskaEntity.id, xor(beleskaEntity.arhiva))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("CHANGE VIEW MODEL COMPLETE")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    private fun xor(other: Boolean): Boolean {
        if (other){
            return false
        }
       return true

    }


    override fun filter(search: String, boolean: Boolean){
        getBySearchBeleska(search,boolean)
    }

    override fun getBySearchBeleska(search : String,boolean: Boolean) {
        val subscription = beleskeRepository.getBySerach(search)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.forEach{ beleskaList.add(it) }
                    val listToSubmit0 = mutableListOf<BeleskaEntity>()
                    listToSubmit0.addAll(beleskaList)
                    beleskaList.clear()
                    beleska.value=listToSubmit0.filter { it.arhiva==boolean }
                },
                {
                    Timber.e(it) },
                {
                    Timber.e("Uspesno pretrazena beleske")
                }
            )
        subscriptions.add(subscription)
    }


    override fun switch(switch: Boolean){
        getBySwitchBeleska(switch)
    }

    override fun getBySwitchBeleska(switch: Boolean) {
        val subscription = beleskeRepository.getBySwitch(switch)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.forEach{ beleskaList.add(it) }
                    val listToSubmit0 = mutableListOf<BeleskaEntity>()
                    listToSubmit0.addAll(beleskaList)
                    beleskaList.clear()
                    beleska.value=listToSubmit0
                },
                {
                    Timber.e(it) },
                {
                    Timber.e("Uspesno pretrazene beleske")
                }
            )
        subscriptions.add(subscription)
    }

    override fun onCleared() {
        subscriptions.clear()
        super.onCleared()
    }

    override fun getByDate(date: Date) {
        val subscription = beleskeRepository.getByDate(date)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.forEach{ beleskaList.add(it) }
                    val listToSubmit0 = mutableListOf<BeleskaEntity>()
                    listToSubmit0.addAll(beleskaList)
                    beleskaList.clear()
                    beleska.value=listToSubmit0
                },
                {
                    Timber.e(it) },
                {
                    Timber.e("Uspesno prikazana statistika")
                }
            )
        subscriptions.add(subscription)
    }

}