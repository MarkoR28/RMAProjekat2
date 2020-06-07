package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.fragments


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rn7417.marko_radojevic_rn7417.R
import kotlinx.android.synthetic.main.fragment_rasprored_casova.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts.PredmetContract
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.adapter.PredmetAdapter
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.PredmetViewModel
import timber.log.Timber
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.SpinnerFilter
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.states.PredmetState

class RasproredCasovaFragment : Fragment(R.layout.fragment_rasprored_casova) {

    private val predmetViewModel: PredmetContract.ViewModel by sharedViewModel<PredmetViewModel>()
    //private val predmetViewModel: PredmetContract.ViewModel by viewModel<PredmetViewModel>()

    private lateinit var adapter: PredmetAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        initSpinners()
        initRecycler()
        initListeners()
    }

    private fun initSpinners(){
        val spinner: Spinner = spinner1
        this.context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.grupe_fakultet,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinner.adapter = adapter
            }
        }

        val spinner2: Spinner = spinner2
        this.context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.dani_fakultet,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinner2.adapter = adapter
            }
        }
    }
    private fun initRecycler() {
        listRvPredmet.layoutManager = LinearLayoutManager(this.activity)
        adapter = PredmetAdapter()
        listRvPredmet.adapter = adapter
    }

    private fun initListeners() {
        /*inputEt.doAfterTextChanged {
            val filter = it.toString()
            predmetViewModel.getPredmetByName(filter)
        }*/
        searchBtn.setOnClickListener{
            val filter = inputEt.text
            val filterPretrage = SpinnerFilter(
                profesor_predmet = inputEt.text.toString(),
                dan = spinner1.selectedItem.toString(),
                grupa = spinner2.selectedItem.toString()
            )
            //predmetViewModel.getPredmetByName(filter.toString())
            predmetViewModel.getPredmetByName(filterPretrage)
        }

    }

    private fun initObservers() {
        predmetViewModel.predmetState.observe(viewLifecycleOwner, Observer {
            Timber.e(it.toString())
            renderState(it)
        })
        predmetViewModel.getAllPredmeti()
        predmetViewModel.fetchAllPredmeti()
    }

    private fun renderState(state: PredmetState) {
        when (state) {
            is PredmetState.Success -> {
                showLoadingState(false)
                adapter.submitList(state.predmeti)
            }
            is PredmetState.Error -> {
                showLoadingState(false)
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is PredmetState.DataFetched -> {
                showLoadingState(false)
                Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_LONG).show()
            }
            is PredmetState.Loading -> {
                showLoadingState(true)
            }
        }
    }

    private fun showLoadingState(loading: Boolean) {
        inputEt.isVisible = !loading
        listRvPredmet.isVisible = !loading
        // TODO dodati loading: loadingPb.isVisible = loading
    }
}

