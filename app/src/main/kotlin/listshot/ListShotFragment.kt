package listshot

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.teste.call.AppDelegate
import br.com.teste.call.R
import br.com.teste.call.model.Shots
import kotlinx.android.synthetic.main.fragment_list_shots.*
import listshot.di.DaggerListShotComponent
import listshot.di.ListShotModule
import javax.inject.Inject

class ListShotFragment: Fragment(), ListShotView {

    @Inject
    lateinit var presenter: ListShotViewPresenter
    
    companion object {
        @JvmStatic
        fun newInstance(): ListShotFragment {
            val fragment = ListShotFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_shots, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerListShotComponent.builder()
                .appComponent(AppDelegate.getComponent())
                .listShotModule(ListShotModule(this))
                .build().inject(this)

        presenter.onCreate(0)
    }

    override fun setView(listShots: List<Shots>) {
    }
    
    override fun onError(throwable: Throwable) {
    }

    override fun showProgress() {
        if (pbLoading != null && pbLoading.visibility == View.VISIBLE) {
            pbLoading.visibility = View.INVISIBLE
        }
        pbLoading.visibility = View.VISIBLE
    }

    override fun dismissProgress() {
        pbLoading.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        if (::presenter.isInitialized) {
            presenter.onDestroy()
        }
        super.onDestroy()
    }


}