package com.ifunsoftware.telegram.bot

import akka.actor.ActorSystem
import spray.http.{HttpEntity, HttpRequest, HttpResponse, MediaTypes}
import spray.client.pipelining._
import spray.http.StatusCodes.Success
import spray.httpx.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._

import scala.concurrent.Future
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.Failure
import scala.util.{Success => ScalaSuccess}


class TelegramBot {
  implicit val system = ActorSystem()
  val token = "331616983:AAHnWOvHqFkNCNJqVuJAx6P7KatGzYY2m7s"
  val chatId = 167389
  val API_URL = "https://api.telegram.org/bot" + token + "/"
  val NO_RESPONSE = "NO_RESPONSE"

  def getAboutInfo:String = {
    val pipeline: HttpRequest => Future[HttpResponse] = sendReceive
    println(API_URL +"getMe")
    val response: Future[HttpResponse] = pipeline(Get(API_URL +"getMe"))

    response onComplete {
      case ScalaSuccess(result) =>  {
        println(result)
        return result.toString
      }

      case Failure(error) => {
        println(error.getMessage)
        return error.getMessage
      }
    }

    NO_RESPONSE
  }

  def send_reply(text:String) = {
    val pipeline: HttpRequest => Future[HttpResponse] = sendReceive
    val response: Future[HttpResponse] = pipeline(Post(API_URL + "sendMessage", "{'chat_id': " + chatId +", 'text': '" + text + "'}"))
    response onComplete {
      case ScalaSuccess(result) => println(result)

      case Failure(error) => println(error.getMessage)
    }
  }
}

object HelloWorld {

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    val tbot:TelegramBot = new TelegramBot()
    val result = tbot.getAboutInfo
    println(result)
    tbot.send_reply("Hello, world!")
  }
}
