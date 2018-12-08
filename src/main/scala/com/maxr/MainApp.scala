package com.maxr

import com.pi4j.io.gpio._

object MainApp extends App {
  println("Starting app")

  val gpio: GpioController = GpioFactory.getInstance
  val led5: GpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Green", PinState.LOW)
  val led6: GpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Red", PinState.LOW)

  setPinState(led5, PinState.HIGH)
  setPinState(led5, PinState.LOW, doSleep = true, 500)
  setPinState(led6, PinState.HIGH)
  setPinState(led6, PinState.LOW, doSleep = false)
  println("All done...")

  def setPinState(pin: GpioPinDigitalOutput, state: PinState, doSleep: Boolean = true, sleepTime: Int = 2000): Unit = {
    println(s"Setting pin '${pin.getName}' to ${state.getValue}")
    pin.setState(state)

    if (doSleep) {
      println(s"Sleeping $sleepTime milliseconds")
      Thread.sleep(2000)
    }
  }
}
