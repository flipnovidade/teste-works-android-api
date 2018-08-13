package listshot

import api.ApiInteractor
import br.com.teste.call.utils.RxComposer
import rx.Subscription
import timber.log.Timber

class ListShotViewPresenterImpl(private val view: ListShotView,
                                private val apiInteractor: ApiInteractor): ListShotViewPresenter {

    private var subscription: Subscription? = null

    override fun onCreate(nPage: Int) {
        subscription = apiInteractor.getShots(nPage.toString())
                .compose(RxComposer.ioThread())
                .doOnSubscribe(view::showProgress)
                .doOnTerminate(view::dismissProgress)
                .subscribe({
                    view.setView(it)
                }, { throwable ->
                    Timber.e(throwable, "Error call updateBroadBandEligibility")
                    view.onError(throwable)
                })
    }

    override fun onDestroy() {
        if (!subscription?.isUnsubscribed!!) {
            subscription?.unsubscribe()
        }
    }


}