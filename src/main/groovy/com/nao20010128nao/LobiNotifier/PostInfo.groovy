package com.nao20010128nao.LobiNotifier

import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FromString

/**
 * Created by nao on 2017/02/04.
 */
class PostInfo {
    Closure<String> success,failed
    Closure<String> beforeStart
    boolean postWhenSuccess=true
    boolean postWhenFailed=true
    boolean postBeforeStart=true
    boolean shout=false
    String destinationGroup

    void destination(String group){
        destinationGroup=group
    }

    void success(@ClosureParams(value=FromString,options = "org.gradle.BuildResult")
                            Closure<String> success) {
        this.success = success
    }

    void failed(@ClosureParams(value=FromString,options = "org.gradle.BuildResult")
                           Closure<String> failed) {
        this.failed = failed
    }

    void beforeStart(@ClosureParams(value=FromString,options = "")
                                Closure<String> beforeStart) {
        this.beforeStart = beforeStart
    }
}
