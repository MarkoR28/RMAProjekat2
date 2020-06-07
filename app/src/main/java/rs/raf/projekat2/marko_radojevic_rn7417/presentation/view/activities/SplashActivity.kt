package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rn7417.marko_radojevic_rn7417.R
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.MainActivity

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nesto()
    }

    fun nesto(){
        val isLogged = appIsPurchased()
        if (isLogged) {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        finish()
    }
    fun appIsPurchased(): Boolean {
        val settings = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
        return settings.getBoolean("isLogged", false)
    }
}