package detailshot.di

import dagger.Module
import dagger.Provides
import detailshot.DetailFragmentPresenter
import detailshot.DetailFragmentPresenterImpl
import detailshot.DetailFragmentView

@Module
class  DetailModule(private val view: DetailFragmentView){

    @Provides
    fun provideDetailView(): DetailFragmentView {
        return this.view
    }

    @Provides
    fun provideDetailPresenter(view: DetailFragmentView): DetailFragmentPresenter {
        return DetailFragmentPresenterImpl(view)
    }

}