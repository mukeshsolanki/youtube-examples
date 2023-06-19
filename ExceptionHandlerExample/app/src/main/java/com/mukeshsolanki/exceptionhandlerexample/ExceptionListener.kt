package com.mukeshsolanki.exceptionhandlerexample

interface ExceptionListener {
  fun unCaughtException(thread: Thread, throwable: Throwable)
}