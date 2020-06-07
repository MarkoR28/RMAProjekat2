package rs.raf.projekat2.marko_radojevic_rn7417.modules

import org.koin.dsl.module
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.experimental.builder.single
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.PredmetRepository
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.UserRepository
import rs.raf.projekat2.marko_radojevic_rn7417.data.local.repositories.UserRepositoryImpl


val userModule = module {
    viewModel { UserViewModel(userRepository = get()) }
    single<UserRepository>{UserRepositoryImpl()}
}