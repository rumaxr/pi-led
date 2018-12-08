package com.maxr

import com.pi4j.io.gpio._

object MainApp extends App {
  println("Starting app")

  val gpio: GpioController = GpioFactory.getInstance
  val led5: GpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Green", PinState.LOW)
  val led6: GpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Red", PinState.LOW)

  setPinState(led5, PinState.HIGH)
  setPinState(led5, PinState.LOW)
  setPinState(led6, PinState.HIGH)
  setPinState(led6, PinState.LOW)
  println("All done...")

  def setPinState(pin: GpioPinDigitalOutput, state: PinState): Unit = {
    println(s"Setting pin '{${pin.getName}}' to {${state.getValue}}")
    pin.setState(state)

    println("Sleeping 2 seconds")
    Thread.sleep(2000)
  }
}
