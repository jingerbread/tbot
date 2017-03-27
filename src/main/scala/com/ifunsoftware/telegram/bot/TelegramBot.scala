package com.ifunsoftware.telegram.bot

import akka.actor.ActorSystem
import spray.http.{HttpRequest, HttpResponse}

import scala.concurrent.Future
import spray.client.pipelining._
import spray.http.StatusCodes.Success

import scala.concurrent.Future
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.Failure

class TelegramBot {
  implicit val system = ActorSystem()
  val token = "331616983:AAHnWOvHqFkNCNJqVuJAx6P7KatGzYY2m7s"

  def getAboutInfo:String = {
    val pipeline: HttpRequest => Future[HttpResponse] = sendReceive
    val getMe:String = s"https://api.telegram.org/bot$token/getMe, $token"
    println(getMe)
    val response: Future[HttpResponse] = pipeline(Get("https://api.telegram.org/bot" + token +"/getMe"))
    response.onComplete({
      case Success(response) => {
        println(response.toString)
      }
      case Failure(exception) => {
        //Do something with my error
      }
    })
  }
}

object HelloWorld {

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    val tbot:TelegramBot = new TelegramBot()
    val result = tbot.getAboutInfo
    println(result)
  }
}
