package api

import br.com.teste.call.model.Shots
import retrofit2.Retrofit
import rx.Observable


interface ApiInteractor {
     fun getShots(page: String): Observable<List<Shots>>
}