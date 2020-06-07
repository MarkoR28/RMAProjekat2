package rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.BeleskaEntity
import java.util.*


interface BeleskaContract {

    interface ViewModel {
        fun insertBeleska(beleskaEntity: BeleskaEntity)
        fun getAllBeleske()
        fun getListBeleska(): LiveData<List<BeleskaEntity>>
        fun updateByIdBeleska(beleskaEntity: BeleskaEntity)
        fun removeByIdBeleska(beleskaEntity: BeleskaEntity)
        fun changeArhivaBeleska(beleskaEntity: BeleskaEntity)
        fun filter(search: String, boolean: Boolean)
        fun getBySearchBeleska(search: String, boolean: Boolean)
        fun switch(switch: Boolean)
        fun getBySwitchBeleska(switch: Boolean)
        fun getByDate(date: Date)

    }

}