package rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.UserRepository
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts.PredmetContract

class UserViewModel (private val userRepository: UserRepository): ViewModel(), PredmetContract.UserViewModel{


    override fun validate(pin1: Int,pin2: Int, pin3: Int, pin4: Int, username: String): Boolean{
        if(userRepository.checkPin(pin1, pin2, pin3, pin4) && userRepository.checkUsername(username)) return true
        return false
    }

}