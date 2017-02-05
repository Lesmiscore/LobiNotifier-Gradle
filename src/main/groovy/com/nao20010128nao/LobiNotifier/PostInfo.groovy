package com.nao20010128nao.LobiNotifier

import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FromString

/**
 * Created by nao on 2017/02/04.
 */
class PostInfo {
    /**
     * Closure to generate messages for success result
     * */
    Closure<String> success
    /**
     * Closure to generate messages for failed result
     * */
    Closure<String> failed
    /**
     * Closure to generate messages to post before the build start
     * */
    Closure<String> beforeStart
    /**
     * Switches posting when the build finishes with the success result
     * */
    boolean postWhenSuccess=true
    /**
     * Switches posting when the build finishes with the failed result
     * */
    boolean postWhenFailed=true
    /**
     * Switches posting before the build starts
     * */
    boolean postBeforeStart=true
    /**
     * Switches shouts when posting<br>
     * true for shout, false for not
     * */
    boolean shout=false
    /**
     * Destination group to post
     * */
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

    void postWhenSuccess(boolean postWhenSuccess) {
        this.postWhenSuccess = postWhenSuccess
    }

    void postWhenFailed(boolean postWhenFailed) {
        this.postWhenFailed = postWhenFailed
    }

    void postBeforeStart(boolean postBeforeStart) {
        this.postBeforeStart = postBeforeStart
    }

    void shout(boolean shout) {
        this.shout = shout
    }
}
