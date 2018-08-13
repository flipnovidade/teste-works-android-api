package detailshot

import java.io.Serializable

interface DetailFragmentPresenter {
    fun onCreate()
    fun onReceiveSerializable(serializable: Serializable?)
    fun onDestroy()
}