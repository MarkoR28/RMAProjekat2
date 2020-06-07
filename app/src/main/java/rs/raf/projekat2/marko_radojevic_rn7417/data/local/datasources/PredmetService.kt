package rs.raf.projekat2.marko_radojevic_rn7417.data.local.datasources

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.models.predmetModels.PredmetResponse

interface PredmetService {

    @GET("json.php")
    fun getAll(@Query("limit") limit: Int = 1000): Observable<List<PredmetResponse>>

}