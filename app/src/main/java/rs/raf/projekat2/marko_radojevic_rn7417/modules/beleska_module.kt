package rs.raf.projekat2.marko_radojevic_rn7417.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.db.BeleskaDatabase
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.BeleskeRepository
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.BeleskeRepositoryImpl
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.BeleskeViewModel

val beleskaModule = module {
    viewModel {BeleskeViewModel(get()) }

    single<BeleskeRepository> { BeleskeRepositoryImpl(get()) }

    single { get<BeleskaDatabase>().getBeleskaDao() }

}
