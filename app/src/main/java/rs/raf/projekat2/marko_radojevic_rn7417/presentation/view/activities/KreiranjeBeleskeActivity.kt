package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rn7417.marko_radojevic_rn7417.R
import kotlinx.android.synthetic.main.activity_kreiranje_beleske.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts.BeleskaContract
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.BeleskeViewModel

class KreiranjeBeleskeActivity: AppCompatActivity(R.layout.activity_kreiranje_beleske)  {

    private val beleskeViewModel : BeleskaContract.ViewModel by viewModel<BeleskeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init(){
        initListener()
    }

    fun initListener(){
        kreirajOdustaniBtn.setOnClickListener {
            finish()
        }

        kreirajPotvrdiBtn.setOnClickListener {
            beleskeViewModel.insertBeleska(
                BeleskaEntity(0,kreirajNazivTxt.text.toString(),kreirajZapisTxt.text.toString(),false)
            )
            finish()
            Toast.makeText(this, "Unos uspesan", Toast.LENGTH_SHORT).show()
        }
    }
}