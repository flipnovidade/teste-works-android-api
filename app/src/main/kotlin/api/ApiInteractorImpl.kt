package api

import br.com.teste.call.AppConstant
import br.com.teste.call.api.API
import br.com.teste.call.model.Shots
import rx.Observable

class ApiInteractorImpl(private val api: API):  ApiInteractor {

    override fun getShots(page: String): Observable<List<Shots>> {
        return api.getShots(AppConstant.Dribbble.Token, page, AppConstant.Dribbble.PER_PAGE)
    }

}