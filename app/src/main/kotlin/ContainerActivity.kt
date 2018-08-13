import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.teste.call.AppActivity
import br.com.teste.call.R
import listshot.ListShotFragment
import uitls.FragmentHelper

class ContainerActivity: AppActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            context.startActivity(Intent(context, ContainerActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        FragmentHelper().openFragmentWithSheetStyle(supportFragmentManager, R.id.sheet_container,
                ListShotFragment.newInstance(), true)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }


}
