package listshot

import br.com.teste.call.model.Shots

interface ListShotView {
    fun onError(throwable: Throwable)
    fun setView(listShots: List<Shots>)
    fun showProgress()
    fun dismissProgress()
}