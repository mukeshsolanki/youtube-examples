package com.mukeshsolanki.exceptionhandlerexample

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log

class SampleApp : Application(), ExceptionListener {

  override fun onCreate() {
    super.onCreate()
    setupExceptionHandler()
  }

  private fun setupExceptionHandler() {
    Handler(Looper.getMainLooper()).post {
      while (true) {
        try {
          Looper.loop()
        } catch (e: Throwable) {
          unCaughtException(Looper.getMainLooper().thread, e)
        }
      }
    }
    Thread.setDefaultUncaughtExceptionHandler { t, e ->
      unCaughtException(t, e)
    }
  }

  override fun unCaughtException(thread: Thread, throwable: Throwable) {
    Log.d("SampleApp", "unCaughtException: ${throwable.printStackTrace()}")
  }
}