package org.chicagosfoodbank.client.survey

/**
 * Created by nick.cruz on 9/23/17.
 */
data class Survey(val id: Int,
                  val name: String,
                  val fields: List<String>)