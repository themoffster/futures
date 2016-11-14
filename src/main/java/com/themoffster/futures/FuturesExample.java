package com.themoffster.futures;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesExample<T> {

  private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(4);
  private List<Callable<T>> requests;

  public FuturesExample(List<Callable<T>> requests) {
    this.requests = requests;
  }

  public List<Future<T>> invoke() throws InterruptedException {
    return EXECUTOR_SERVICE.invokeAll(requests);
  }
}
