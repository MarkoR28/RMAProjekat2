package rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories

import io.reactivex.Completable
import io.reactivex.Observable

interface UserRepository {

    fun checkPin(pin1: Int,pin2: Int, pin3: Int, pin4: Int ): Boolean
    fun checkUsername(username: String): Boolean

}