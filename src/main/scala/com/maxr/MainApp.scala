package com.maxr

import com.pi4j.io.gpio._

object MainApp extends App {
  println("Starting app")

  val gpio: GpioController = GpioFactory.getInstance
  val led: GpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "MyLed", PinState.LOW)

  println("Setting pin 10 to high")
  led.setState(PinState.HIGH)
  println("Sleeping 5 seconds")
  Thread.sleep(5000)
  println("Setting pin 10 to low")
  led.setState(PinState.LOW)
  println("All done...")
}
