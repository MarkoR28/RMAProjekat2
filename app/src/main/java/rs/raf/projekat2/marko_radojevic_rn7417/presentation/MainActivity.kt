package rs.raf.projekat2.marko_radojevic_rn7417.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rn7417.marko_radojevic_rn7417.R
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.activities.BottomNavigationActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    private fun init(){
        initBottomNavigation()
    }

    private fun initBottomNavigation(){
        val intent = Intent(this, BottomNavigationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }
}
