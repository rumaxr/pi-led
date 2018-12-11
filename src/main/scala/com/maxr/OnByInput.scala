package com.maxr

import com.maxr.util.{Pin => utilPin}
import com.pi4j.io.gpio._

import scala.io.StdIn

object OnByInput extends App {
  val gpIo: GpioController = GpioFactory.getInstance
  val led5: GpioPinDigitalOutput = gpIo.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Green", PinState.LOW)
  val led6: GpioPinDigitalOutput = gpIo.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Red", PinState.LOW)
  val led26: GpioPinDigitalOutput = gpIo.provisionDigitalOutputPin(RaspiPin.GPIO_26, "Blue", PinState.LOW)

  def readInput(): Unit = {

    println("r, g, b or q")

    val char: Char = StdIn.readChar()
    char match {
      case 'r' => {
        utilPin.setPinStateAndSleep(led6, PinState.HIGH, sleepTime = 2000)
        utilPin.setPinStateAndSleep(led6, PinState.LOW, doSleep = false)
        readInput()
      }
      case 'g' => {
        utilPin.setPinStateAndSleep(led5, PinState.HIGH, sleepTime = 2000)
        utilPin.setPinStateAndSleep(led5, PinState.LOW, doSleep = false)
        readInput()
      }
      case 'b' => {
        utilPin.setPinStateAndSleep(led26, PinState.HIGH, sleepTime = 2000)
        utilPin.setPinStateAndSleep(led26, PinState.LOW, doSleep = false)
        readInput()
      }
      case _ => {
        println("Quitting...")
      }
    }
  }

  readInput()
}
