package di

import android.content.Context
import api.ApiInteractor
import br.com.teste.call.AppDelegate
import br.com.teste.call.api.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApiModule::class))
interface AppComponent {

    fun inject(app: AppDelegate)

    fun apiInteractor(): ApiInteractor

    fun context(): Context

}