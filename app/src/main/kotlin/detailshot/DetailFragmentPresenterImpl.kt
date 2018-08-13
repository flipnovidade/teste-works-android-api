package detailshot

import api.ApiInteractor
import br.com.teste.call.model.Shots
import rx.Subscription
import java.io.Serializable

class DetailFragmentPresenterImpl(private val view: DetailFragmentView) : DetailFragmentPresenter {
    private var shot: Shots? = null


    override fun onCreate() {
        shot?.let {
            view.configureView(it)
        }
    }

    override fun onReceiveSerializable(serializable: Serializable?) {
        if(serializable is Shots){
            shot = serializable
        }
    }

    override fun onDestroy() {}


}