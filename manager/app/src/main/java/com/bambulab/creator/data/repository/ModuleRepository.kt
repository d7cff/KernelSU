package com.bambulab.creator.data.repository

import com.bambulab.creator.data.model.Module
import com.bambulab.creator.data.model.ModuleUpdateInfo

interface ModuleRepository {
    suspend fun getModules(): Result<List<Module>>
    suspend fun checkUpdate(module: Module): Result<ModuleUpdateInfo>
}
