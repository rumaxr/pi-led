package com.maxr

import com.pi4j.io.gpio._

object MainApp extends App {
  println("Starting app")

  val gpio: GpioController = GpioFactory.getInstance
  val led: GpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "MyLed", PinState.LOW)

  println("Setting LED 24 to high")
  led.setState(PinState.HIGH)
  Thread.sleep(5000)
  println("Setting LED 24 to low")
  led.setState(PinState.LOW)

  println("All done...")
}
