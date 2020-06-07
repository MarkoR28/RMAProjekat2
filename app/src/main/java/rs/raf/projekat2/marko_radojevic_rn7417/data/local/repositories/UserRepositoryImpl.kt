package rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories

import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.UserModel

class UserRepositoryImpl(): UserRepository{

    private val user: UserModel = UserModel()

    override fun checkPin(pin1: Int, pin2: Int, pin3: Int, pin4: Int): Boolean {
        if (pin1 == user.pin1 && pin2 == user.pin2 && pin3 == user.pin3 && pin4 == user.pin4) return true
        return false
    }

    override fun checkUsername(username: String): Boolean {
        if(username == user.naziv || username == user.naziv2) return true
        return false
    }

}