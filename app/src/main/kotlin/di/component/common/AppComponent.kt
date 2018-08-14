package di.component.common

import android.content.Context
import api.ApiInteractor
import br.com.teste.call.AppDelegate
import br.com.teste.call.di.module.common.AppModule
import br.com.teste.call.di.module.common.InteractorModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (InteractorModule::class)])
interface AppComponent {

    fun inject(app: AppDelegate)

    fun apiInteractor(): ApiInteractor

    fun context(): Context

}