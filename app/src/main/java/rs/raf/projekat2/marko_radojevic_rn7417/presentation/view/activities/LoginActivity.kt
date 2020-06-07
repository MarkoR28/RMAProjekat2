package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.MainActivity
import com.rn7417.marko_radojevic_rn7417.R
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.UserViewModel

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private val userViewModel : UserViewModel by viewModel<UserViewModel>()

    companion object {
        var MESSAGE = ""
        val DURATION = Toast.LENGTH_SHORT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        unesitepinBtn.setOnClickListener{
            pin4Et.visibility = View.VISIBLE
            pin3Et.visibility = View.VISIBLE
            pin2Et.visibility = View.VISIBLE
            pin1Et.visibility = View.VISIBLE
        }

        prijavaBtn.setOnClickListener{
            if(pin1Et?.text.toString().isNotEmpty() && pin2Et?.text.toString().isNotEmpty() && pin3Et?.text.toString().isNotEmpty() && pin4Et?.text.toString().isNotEmpty() && firstnameTv.text.toString().isNotEmpty()) {
                if (userViewModel.validate(
                        pin1Et?.text.toString().toInt(),
                        pin2Et?.text.toString().toInt(),
                        pin3Et?.text.toString().toInt(),
                        pin4Et?.text.toString().toInt(),
                        firstnameTv?.text.toString()
                    )
                ) {
                    val settings = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
                    val editor = settings.edit()
                    editor.clear()
                    editor.putBoolean("isLogged", true)
                    editor.putString("firstname", firstnameTv.text.toString())
                    editor.commit()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    MESSAGE = "Neispravan unos"
                    popupToast()
                }
            }
            else {
                MESSAGE = "Neispravan unos"
                popupToast()
            }
        }
    }
    private fun popupToast(){
        val toast = Toast.makeText(applicationContext,
            MESSAGE,
            DURATION
        )
        toast.show()
    }
}
