package com.ifunsoftware.telegram.bot

/**
  * Created by jingerbread on 25/03/2017.
  */



class TelegramBot {
  val token = "331616983:AAHnWOvHqFkNCNJqVuJAx6P7KatGzYY2m7s"

  def getAboutInfo():String = {
    //val pipeline: HttpRequest => Future[HttpResponse] = sendReceive
    //val response: Future[HttpResponse] = pipeline(Get("http://spray.io/"))

    ""
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
