package com.maxr

import com.pi4j.io.gpio._

object MainApp extends App {
  println("Starting app")

  val gpio: GpioController = GpioFactory.getInstance
  val led5: GpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Green", PinState.LOW)
  val led6: GpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Red", PinState.LOW)

  0 until 5 foreach { _ =>
    setPinState(led5, PinState.HIGH)
    setPinState(led5, PinState.LOW, sleepTime = 100)
    setPinState(led6, PinState.HIGH)
    setPinState(led6, PinState.LOW, sleepTime = 100)
  }

  println("All done...")

  def setPinState(pin: GpioPinDigitalOutput, state: PinState, doSleep: Boolean = true, sleepTime: Int = 500): Unit = {
    println(s"Setting pin '${pin.getName}' to ${state.getValue}")
    pin.setState(state)

    if (doSleep) {
      println(s"Sleeping $sleepTime milliseconds")
      Thread.sleep(sleepTime)
    }
  }
}
