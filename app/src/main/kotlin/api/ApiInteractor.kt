package api

import br.com.teste.call.model.Shots
import rx.Observable

interface ApiInteractor {
     fun getShots(page: String): Observable<List<Shots>>
}