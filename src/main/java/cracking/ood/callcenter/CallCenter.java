package cracking.ood.callcenter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Implement call center.
 */
public class CallCenter implements Consumer<Call> {
  private static final int NUMBER_RESPONDENTS = 3;
  private static final int NUMBER_MANAGERS = 2;

  private BlockingQueue<Call> callQueue = new ArrayBlockingQueue<>(10);
  private BlockingQueue<Respondent> respondents = new ArrayBlockingQueue<>(NUMBER_RESPONDENTS);
  private BlockingQueue<Manager> managers = new ArrayBlockingQueue<>(NUMBER_MANAGERS);
  private Director director = new Director("Director");


  private boolean isRunning = true;
  private final ExecutorService threadPool;

  public CallCenter() {
    for (int i = 0; i < NUMBER_RESPONDENTS; i++) {
      respondents.add(new Respondent("Respondent " + (i + 1)));
    }
    for (int i = 0; i < NUMBER_MANAGERS; i++) {
      managers.add(new Manager("Manager " + (i + 1)));
    }
    threadPool = Executors.newCachedThreadPool();
  }

  public void start() {
    new Thread(() -> {
      while (isRunning || !callQueue.isEmpty()) {
        try {
          Call call = callQueue.poll(1, TimeUnit.SECONDS);
          if (call != null) {
            handleCall(call);
          }
        } catch (InterruptedException ignored) {
          break;
        }
      }
    }).start();
  }

  public void stop() {
    isRunning = false;
  }

  @Override
  public void accept(Call call) {
    System.out.format("Received: %s %n", call);
    callQueue.add(call);
  }

  private void handleCall(Call call) {
    try {
      Respondent respondent = respondents.take();
      Runnable respondentTask = () -> {
        if (respondent.handleCall(call)) {
          tryShutdownThreadPool();
        } else {
          Runnable managerTask = () -> {
            try {
              Manager manager = managers.take();
              if (manager.handleCall(call)) {
                tryShutdownThreadPool();
              } else {
                Runnable directorTask = () -> {
                  director.handleCall(call);
                  tryShutdownThreadPool();
                };
                threadPool.execute(directorTask);
              }
              managers.add(manager);
            } catch (InterruptedException ignored) {
            }
          };
          threadPool.execute(managerTask);
        }
        respondents.add(respondent);
      };
      threadPool.execute(respondentTask);
    } catch (InterruptedException ignored) {
    }
  }

  private void tryShutdownThreadPool() {
    if(!isRunning && callQueue.isEmpty()) {
      threadPool.shutdown();
    }
  }
}
