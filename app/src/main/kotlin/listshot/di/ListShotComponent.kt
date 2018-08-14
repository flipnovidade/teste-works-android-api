package listshot.di

import br.com.teste.call.di.scope.FragmentScope
import dagger.Component
import di.component.common.AppComponent
import listshot.ListShotFragment

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ListShotModule::class))
interface ListShotComponent {
    fun inject(fragment: ListShotFragment)
}
