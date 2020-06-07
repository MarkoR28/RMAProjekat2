package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rn7417.marko_radojevic_rn7417.R
import kotlinx.android.synthetic.main.fragment_pisanje_beleski.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts.BeleskaContract
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.activities.KreiranjeBeleskeActivity
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.activities.PromeniBeleskeActivity
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.adapter.BeleskeAdapter
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.recycler.diff.BeleskeDiffCallback
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.BeleskeViewModel
import timber.log.Timber


class PisanjeBeleskiFragment : Fragment(R.layout.fragment_pisanje_beleski) {

    private val beleskeViewModel : BeleskaContract.ViewModel by viewModel<BeleskeViewModel>()
    private lateinit var beleskeAdapter: BeleskeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initUI()
        initObservers()
        initListeners()
    }

    private fun initUI(){
        initRecycler()
    }

    private fun initListeners(){
        initListenersSearch()
        initListenersSwitch()
        initListenersDodaj()
    }

    var switchFilter :Boolean=false
    private fun initListenersSearch(){
        searchView.doAfterTextChanged {
            beleskeViewModel.filter(it.toString(), switchFilter )
        }
    }

    private fun initListenersSwitch(){
        switchBtn.setOnCheckedChangeListener{ compoundButton, isChecked: Boolean ->
            if(isChecked){
                beleskeViewModel.switch(isChecked)
                switchFilter = true
            }else{
                beleskeViewModel.switch(isChecked)
                switchFilter = false
            }
        }
    }


    private fun initListenersDodaj(){
        dodajBeleskuBtn.setOnClickListener {
            val intent = Intent(activity, KreiranjeBeleskeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initObservers(){
        beleskeViewModel.getListBeleska().observe(viewLifecycleOwner, Observer {
            beleskeAdapter.submitList(it)
        })
        beleskeViewModel.getAllBeleske()
    }

    private fun initRecycler(){
        listRvBeleska.layoutManager = LinearLayoutManager(this.context)
        beleskeAdapter=
            BeleskeAdapter(
                BeleskeDiffCallback(),
                {
                    beleskeViewModel.removeByIdBeleska(it)
                },
                {
                    val intent = Intent(activity, PromeniBeleskeActivity::class.java)
                    intent.putExtra("beleska",it)
                    startActivity(intent)
                },
                {
                    beleskeViewModel.changeArhivaBeleska(it)
                }

            )
        listRvBeleska.adapter = beleskeAdapter
    }


}