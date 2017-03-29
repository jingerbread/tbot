package com.ifunsoftware.telegram.bot

import spray.http.ContentTypes
import spray.httpx.marshalling.Marshaller
import spray.json._
/**
  *
  * @author Maria Fedorova 
  * @since 28/03/2017.
  */
case class Message(chatId: Int, text:String)

object MessageJsonProtocol extends DefaultJsonProtocol {

  implicit def createMessageFormat: JsonFormat[Message] = jsonFormat2(Message)

//  implicit def sprayJsonMarshaller[T](implicit writer: RootJsonWriter[T], printer: JsonPrinter = PrettyPrinter) =
//    Marshaller.delegate[T, String](ContentTypes.`application/json`) { value ⇒
//      val json = writer.write(value)
//      printer(json)
//    }
}
