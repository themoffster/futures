package com.themoffster.futures.tasks;

import org.joda.time.LocalDateTime;

public class YetAnotherLongRunningTask extends LongRunningTask {

  @Override
  public YetAnotherLongRunningTask call() throws Exception {
    Thread.sleep(10000);
    YetAnotherLongRunningTask task = new YetAnotherLongRunningTask();
    task.setTimestamp(new LocalDateTime());
    return task;
  }
}
