package com.ifunsoftware.telegram.bot

import spray.http.{ContentTypes, HttpEntity, MediaType, MediaTypes}
import spray.httpx.marshalling.{Marshaller, MarshallingContext}
import spray.json._

case class Message(chatId: Int, text:String)

object MessageJsonProtocol extends DefaultJsonProtocol {

  implicit def createMessageFormat: JsonFormat[Message] = jsonFormat2(Message)

  implicit val MessageMarshaller =
    Marshaller.of[Message](MediaTypes.register(MediaType.custom("application/json"))) { (value, contentType, ctx) =>
      val Message(chatId, text) = value
      val string = "'chatId': %s,'text': %s".format(chatId, text)
      ctx.marshalTo(HttpEntity(contentType, string))
    }
}

