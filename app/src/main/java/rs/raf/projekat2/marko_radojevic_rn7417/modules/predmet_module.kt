package rs.raf.projekat2.marko_radojevic_rn7417.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.create
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.datasources.PredmetService
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.db.PredmetDataBase
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.PredmetRepository
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.PredmetRepositoryImpl
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.PredmetViewModel
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.UserViewModel

val predmetModule = module {

    viewModel { PredmetViewModel(predmetRepository = get()) }

    single<PredmetRepository> { PredmetRepositoryImpl(localDataSource = get(), remoteDataSource = get()) }

    single { get<PredmetDataBase>().getPredmetDao() }

    single<PredmetService> { create(retrofit = get()) }

}
