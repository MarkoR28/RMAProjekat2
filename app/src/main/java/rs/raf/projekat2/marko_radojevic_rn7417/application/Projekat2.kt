package rs.raf.projekat2.marko_radojevic_rn7417.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import rs.raf.projekat2.marko_radojevic_rn7417.modules.coreModule
import rs.raf.projekat2.marko_radojevic_rn7417.modules.beleskaModule
import rs.raf.projekat2.marko_radojevic_rn7417.modules.predmetModule
import rs.raf.projekat2.marko_radojevic_rn7417.modules.userModule
import timber.log.Timber


class Projekat2 : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        initTimber()
        initKoin()
        initStetho()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        val modules = listOf(
            coreModule,
            beleskaModule,
            predmetModule,
            userModule
           // rxUserModule,
           // threadingModule
        )
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Projekat2)
            androidFileProperties()
            fragmentFactory()
            modules(modules)
        }
    }
    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }
}