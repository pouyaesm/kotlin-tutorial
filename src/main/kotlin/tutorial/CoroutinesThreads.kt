package tutorial

import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) {
  println("Before calling launch")
  launch {
    var result = 0
    val duration = measureTimeMillis { result = combine() }
    println("Result of async combine of three 1 sec functions: $result, duration: $duration ms")
  }
  /**
   * This 'println' will be executed before the 'println' inside 'launch'
   * since the main thread will not wait for the completion of code
   * inside 'launch'. To execute this println after combined result,
   * add 'runBlocking' to main function and remove the launch {};
   * this way, main thread will wait for the result and then proceeds
   * to next lines
    */
  println("After calling launch")

  // Compare co-routine vs thread performance
  // Threads have major memory / time overhead for over 10K threads
  val jobs = 1..20_000
  val coRoutingDuration = measureTimeMillis { useCoRoutines(jobs) }
  println("${jobs.count()} jobs ran on co-routines in $coRoutingDuration ms")

  val threadDuration = measureTimeMillis { useThreads(jobs) }
  println("${jobs.count()} jobs ran on threads in $threadDuration ms")
}

/**
 * Combine the result of asynchronously executed functions
 * using 'await'; Either use 'suspend' keyword or wait for
 * the result of suspended functions in a 'launch' or 'runBlocking' block
 */
suspend fun combine() : Int {
  // result retrievers are executed asynchronously
  val firstResult = async{ retrieve(1) }
  val secondResult = async{ retrieve(2) }
  val thirdResult = async{ retrieve(3) }
  // .await() blocks the thread until the value of async function is returned
  return firstResult.await() + secondResult.await() + thirdResult.await()
}

/**
 * Keyword 'suspend' indicates that function is blocking
 * and it takes time for the function to return a result
 * This function is an analogy to IO jobs
 */
suspend fun retrieve(num: Int) : Int {
  delay(1000L)
  return num * 2
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
    // CommonPool: use a shared thread
    // Unconfined: use any thread and skip back and forth
    // UI: execute the block inside launch in UI thread (for android)
    val job = launch(CommonPool) {
      delay(1000L)  // 1 second
    }
    coRoutines.add(job)
  }
  coRoutines.forEach {
    it.join() // wait for co-routine completion
  }
}