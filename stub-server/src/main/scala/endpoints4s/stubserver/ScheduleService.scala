package endpoints4s.stubserver

import org.apache.pekko.actor.Scheduler

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

/** Service that schedules a task to run after a delay.
  * Used when handling /schedule requests.
  */
object ScheduleService {

  def scheduleOnce(delayMs: Long)(implicit
      scheduler: Scheduler,
      ec: ExecutionContext
  ): Unit = {
    val delay = FiniteDuration(delayMs, MILLISECONDS)
    //CWE-400
    //SINK
    scheduler.scheduleOnce(delay, () => ())
  }
}
