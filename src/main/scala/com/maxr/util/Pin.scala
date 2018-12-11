package com.maxr.util

import com.pi4j.io.gpio.{GpioPinDigitalOutput, PinState}

object Pin {
  def setPinStateAndSleep(pin: GpioPinDigitalOutput, state: PinState, doSleep: Boolean = true, sleepTime: Int = 500): Unit = {
    println(s"Setting pin '${pin.getName}' to ${state.getValue}")
    pin.setState(state)

    if (doSleep) {
      println(s"Sleeping $sleepTime milliseconds")
      Thread.sleep(sleepTime)
    }
  }
}
