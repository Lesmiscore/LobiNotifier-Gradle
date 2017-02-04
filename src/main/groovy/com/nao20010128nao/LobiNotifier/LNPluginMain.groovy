package com.nao20010128nao.LobiNotifier

import com.nao20010128nao.BloodyGarden.LobiServices
import org.gradle.BuildResult
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by nao on 2017/02/03.
 */
class LNPluginMain implements Plugin<Project> {
    LobiConfiguration config
    LobiServices services
    void apply(Project project) {
        config=project.extensions.create('lobi', LobiConfiguration)

        project.gradle.buildStarted {
            if(!LobiServices.checkAvailable()){
                System.err.println "Skipping logging in, because Lobi is unavailable. (Slow down?)"
                return
            }
            if(config.danger.userAgent!=null){
                println "ATTENTION: User agent for Lobi API access is set to \"${config.danger.userAgent}\".\nThis change may cause API calls errors."
                LobiServices.PC_USER_AGENT=config.danger.userAgent
            }
            println "Trying to log into Lobi."
            services=new LobiServices()
            def login=config.login
            if(login.twitter){
                services.twitterLogin(login.username,login.password)
            }else{
                services.login(login.username,login.password)
            }
            println "Done."
            def post=config.post
            if(post.postBeforeStart){
                services.newThread(post.destinationGroup,post.beforeStart(),post.shout)
            }
        }
        project.gradle.buildFinished { BuildResult result->
            if(services==null)return
            def post=config.post
            if(result.failure!=null){
                if(post.postWhenSuccess){
                    services.newThread(post.destinationGroup,post.success(result),post.shout)
                }
            }else{
                if(post.postWhenFailed){
                    services.newThread(post.destinationGroup,post.failed(result),post.shout)
                }
            }
        }
    }
}
