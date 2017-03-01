package cracking.ood.callcenter;

public class Director extends Employee {
  Director(String name) {
    super(name);
  }

  @Override
  public boolean handleCall(Call call) {
    System.out.format("%s: Started %s %n", getName(), call);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ignored) {
      return false;
    }
    System.out.format("%s: Finished %s %n", getName(), call);
    return true;
  }
}


