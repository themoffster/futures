package com.themoffster.futures.tasks;

import org.joda.time.LocalDateTime;

public class AnotherLongRunningTask extends LongRunningTask {

  @Override
  public AnotherLongRunningTask call() throws Exception {
    Thread.sleep(5000);
    AnotherLongRunningTask task = new AnotherLongRunningTask();
    task.setTimestamp(new LocalDateTime());
    return task;
  }
}
