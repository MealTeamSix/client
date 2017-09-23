package org.chicagosfoodbank.client

/**
 * Created by nick.cruz on 9/23/17.
 */
class BasicLogin : LoginTask {

    fun setCredentials(username: String, password: String) {
        // do nothing for now
    }

    override fun login(): Boolean = true
}