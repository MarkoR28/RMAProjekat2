package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rn7417.marko_radojevic_rn7417.R
import kotlinx.android.synthetic.main.activity_promeni_beleske.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts.BeleskaContract
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.BeleskeViewModel

class PromeniBeleskeActivity : AppCompatActivity(R.layout.activity_promeni_beleske) {

    private val beleskeViewModel : BeleskaContract.ViewModel by viewModel<BeleskeViewModel>()
    private var id:Long = 0
    private var arhiva:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val beleska = intent?.getParcelableExtra<BeleskaEntity>("beleska")
        if (beleska != null) {
            id = beleska.id
            arhiva=beleska.arhiva
            nazivLb.text = beleska.naziv
            zapisLb.text = beleska.zapis
        }else{
            Toast.makeText(this, "Doslo je do greske pri popunjavanju", Toast.LENGTH_SHORT).show()
        }
        init()
    }

    private fun init(){
        initListener()
    }

    private fun initListener(){
        odustaniBtn.setOnClickListener {
            finish()
        }
        izmeniBtn.setOnClickListener {
            beleskeViewModel.updateByIdBeleska(
                BeleskaEntity(id,noviNazivTxt.text.toString(),noviZapisTxt.text.toString(),arhiva)
            )
            finish()
            Toast.makeText(this, "Izmena uspesna", Toast.LENGTH_SHORT).show()
        }
    }
}
