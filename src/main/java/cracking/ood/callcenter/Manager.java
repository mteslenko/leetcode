package cracking.ood.callcenter;

public class Manager extends Employee {
  Manager(String name) {
    super(name);
  }

  @Override
  public boolean handleCall(Call call) {
    System.out.format("%s: Started %s %n", getName(), call);
    try {
      if (call.isVeryDifficult()) {
        Thread.sleep(2000);
        return false;
      } else {
        Thread.sleep(1000);
      }
    } catch (InterruptedException ignored) {
      return false;
    }
    System.out.format("%s: Finished %s %n", getName(), call);
    return true;
  }
}


