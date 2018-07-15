package tutorial

import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.experimental.*

fun main(args: Array<String>){
  println("Hello, world!")

  // Threads have major memory / time overhead for over 10K threads
  val jobs = 1..50_000
  val coRoutingDuration = measureTimeMillis { useCoRoutines(jobs) }
  println("${jobs.count()} jobs ran on thread in $coRoutingDuration ms")

  val threadDuration = measureTimeMillis { useThreads(jobs) }
  println("${jobs.count()} jobs ran on thread in $threadDuration ms")
}

fun useThreads(jobs: IntRange){
  val threads : MutableList<Thread> = mutableListOf()
  jobs.forEach {
    val thread = thread {
      Thread.sleep(1000L)  // 1 second
    }
    threads.add(thread)
  }
  threads.forEach {
    it.join() // wait for thread completion
  }
}

fun useCoRoutines(jobs: IntRange) = runBlocking {
  val coRoutines : MutableList<Job> = mutableListOf()
  jobs.forEach {
    val job = launch(CommonPool) {
      delay(1000L)  // 1 second
    }
    coRoutines.add(job)
  }
  coRoutines.forEach {
    it.join() // wait for co-routine completion
  }
}