package com.themoffster.futures;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.themoffster.futures.tasks.AnotherLongRunningTask;
import com.themoffster.futures.tasks.LongRunningTask;
import com.themoffster.futures.tasks.YetAnotherLongRunningTask;

public class FuturesExampleTest {

  private static FuturesExample<LongRunningTask> future;
  private static List<Callable<LongRunningTask>> requests;
  private static final Logger LOGGER = Logger.getLogger(FuturesExampleTest.class);

  static {
    requests = new ArrayList<Callable<LongRunningTask>>();
    requests.add(new LongRunningTask());
    requests.add(new AnotherLongRunningTask());
    requests.add(new YetAnotherLongRunningTask());
    future = new FuturesExample<LongRunningTask>(requests);
  }

  @Test
  public void invoke() throws InterruptedException, ExecutionException {
    List<Future<LongRunningTask>> responses = future.invoke();
    for (Future<LongRunningTask> response : responses) {
      assertTrue(response.isDone());
      LongRunningTask task = response.get();
      LOGGER.info(task.getClass().getName() + " " + task.getTimestamp());
    }
  }
}
