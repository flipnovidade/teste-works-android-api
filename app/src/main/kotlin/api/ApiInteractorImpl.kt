package api

import br.com.teste.call.AppConstant
import br.com.teste.call.api.API
import br.com.teste.call.api.ApiModule
import br.com.teste.call.model.Shots
import retrofit2.Retrofit
import rx.Observable

class ApiInteractorImpl(private val api: ApiModule, private val adapter: Retrofit):  ApiInteractor {

    override fun getShots(page: String): Observable<List<Shots>> {
        return api.provideService(adapter).getShots(AppConstant.Dribbble.Token, page, AppConstant.Dribbble.PER_PAGE)
    }

}