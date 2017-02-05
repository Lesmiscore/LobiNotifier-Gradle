package com.nao20010128nao.LobiNotifier

/**
 * Created by nao on 2017/02/03.
 */
class LoginInfo {
    /**
     * Use Twitter login or not
     * */
    boolean twitter=false
    /**
     * Email for login
     * */
    String username
    /**
     * Password for login
     * */
    String password

    void email(String username){
        this.username=username
    }
    void username(String username){
        this.username=username
    }
    void password(String password){
        this.password=password
    }
}
