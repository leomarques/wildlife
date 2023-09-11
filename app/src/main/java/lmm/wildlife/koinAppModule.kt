package lmm.wildlife

import lmm.domain.domainModule
import lmm.wildlife.ui.animals.AnimalsViewModel
import lmm.wildlife.ui.setup.SetupViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val appModule = module {
    loadKoinModules(domainModule)

    viewModelOf(::SetupViewModel)
    viewModelOf(::AnimalsViewModel)
}
