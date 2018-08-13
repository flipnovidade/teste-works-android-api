package detailshot

import br.com.teste.call.model.Shots

interface DetailFragmentView {
    fun configureView(shot: Shots)
}