package rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Predmet
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.Resource
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.SpinnerFilter
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.PredmetRepository
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts.PredmetContract
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.states.PredmetState
import timber.log.Timber
import java.util.concurrent.TimeUnit

class PredmetViewModel(
    private val predmetRepository: PredmetRepository
) : ViewModel(), PredmetContract.ViewModel {

    private val subscriptions = CompositeDisposable()
    override val predmetState: MutableLiveData<PredmetState> = MutableLiveData()

    private val publishSubject: PublishSubject<SpinnerFilter> = PublishSubject.create()

    /*init {
        val subscription = publishSubject
            .debounce(200, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .switchMap {
                predmetRepository
                    .getAllByName(it.profesor_predmet)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError {
                        Timber.e("Error in publish subject")
                        Timber.e(it)
                    }
            }
            .subscribe(
                {
                    predmetState.value = PredmetState.Success(it)
                },
                {
                    predmetState.value = PredmetState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }*/
    init {
        val subscription = publishSubject
            .debounce(200, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .switchMap {
                predmetRepository
                    .getByParameters(it.profesor_predmet, it.grupa, it.dan)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError {
                        Timber.e("Error in publish subject")
                        Timber.e(it)
                    }
            }
            .subscribe(
                {
                    predmetState.value = PredmetState.Success(it)
                },
                {
                    predmetState.value = PredmetState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun fetchAllPredmeti() {
        val subscription = predmetRepository
            .fetchAll()
            .startWith(Resource.Loading()) //Kada se pokrene fetch hocemo da postavimo stanje na Loading
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when(it) {
                        is Resource.Loading -> predmetState.value = PredmetState.Loading
                        is Resource.Success -> predmetState.value = PredmetState.DataFetched
                        is Resource.Error -> predmetState.value = PredmetState.Error("Error happened while fetching data from the server")
                    }
                },
                {
                    predmetState.value = PredmetState.Error("Error happened while fetching data from the server")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllPredmeti() {
        val subscription = predmetRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    predmetState.value = PredmetState.Success(it)
                },
                {
                    predmetState.value = PredmetState.Error("Error happened while fetching data from db")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    /*override fun getPredmetByName(name: String) {
        publishSubject.onNext(name)
    }*/
    override fun getPredmetByName(filter: SpinnerFilter) {
        publishSubject.onNext(filter)
    }

    override fun addPredmet(predmet: Predmet) {
        TODO()
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}