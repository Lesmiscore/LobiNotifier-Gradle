package com.nao20010128nao.LobiNotifier

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by nao on 2017/02/03.
 */
class LNPluginMain implements Plugin<Project> {
    void apply(Project project) {
        project.gradle.buildFinished {result->
            result.failed
        }

        project.extensions.create('lobi', LobiConfiguration)
    }
}
