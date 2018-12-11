package com.maxr

import com.pi4j.io.gpio._
import com.maxr.util.{Pin => utilPin}

object BlinkInARowLoopApp extends App {
  println("Starting app")

  val gpIo: GpioController = GpioFactory.getInstance
  val led5: GpioPinDigitalOutput = gpIo.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Green", PinState.LOW)
  val led6: GpioPinDigitalOutput = gpIo.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Red", PinState.LOW)
  val led26: GpioPinDigitalOutput = gpIo.provisionDigitalOutputPin(RaspiPin.GPIO_26, "Blue", PinState.LOW)

  0 until 5 foreach { _ =>
    utilPin.setPinStateAndSleep(led5, PinState.HIGH)
    utilPin.setPinStateAndSleep(led5, PinState.LOW, sleepTime = 100)
    utilPin.setPinStateAndSleep(led6, PinState.HIGH)
    utilPin.setPinStateAndSleep(led6, PinState.LOW, sleepTime = 100)
    utilPin.setPinStateAndSleep(led26, PinState.HIGH)
    utilPin.setPinStateAndSleep(led26, PinState.LOW, sleepTime = 100)
  }

  println("All done...")
}
