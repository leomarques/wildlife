package lmm.domain

import lmm.data.dataModule
import lmm.domain.interactors.DataInteractor
import lmm.domain.interactors.GetAllAnimalsInteractor
import lmm.domain.interactors.SaveAllAnimalsInteractor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    loadKoinModules(dataModule)

    factoryOf(::GetAllAnimalsInteractor)
    factoryOf(::SaveAllAnimalsInteractor)
    factoryOf(::DataInteractor)
}
