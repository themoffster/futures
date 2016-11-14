package com.themoffster.futures.tasks;

import java.util.concurrent.Callable;

import org.joda.time.LocalDateTime;

public class LongRunningTask implements Callable<LongRunningTask> {

  private LocalDateTime timestamp;

  @Override
  public LongRunningTask call() throws Exception {
    Thread.sleep(2000);
    LongRunningTask task = new LongRunningTask();
    task.setTimestamp(new LocalDateTime());
    return task;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
