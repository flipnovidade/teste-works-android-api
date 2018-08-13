package detailshot.di

import br.com.teste.call.di.FragmentScope
import dagger.Component
import detailshot.DetailFragment
import di.AppComponent

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(DetailModule::class))
interface DetailCompoment {
    fun inject(fragment: DetailFragment)
}
