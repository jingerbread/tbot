package com.ifunsoftware.telegram.bot

import spray.httpx.SprayJsonSupport._
import spray.json._
import spray.json._
/**
  *
  * @author Maria Fedorova 
  * @since 28/03/2017.
  */
case class Message(chatId: Int, text:String)

object MessageJsonProtocol extends DefaultJsonProtocol {
  implicit def createMessageFormat: JsonFormat[Message] = jsonFormat4(Message)
}
