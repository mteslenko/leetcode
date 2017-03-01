package cracking.ood.callcenter;

public class Respondent extends Employee {
  Respondent(String name) {
    super(name);
  }

  @Override
  public boolean handleCall(Call call) {
    System.out.format("%s: Started %s %n", getName(), call);
    try {
      if (call.isDifficult() || call.isVeryDifficult()) {
        Thread.sleep(2000);
        return false;
      } else {
        Thread.sleep(1000);
      }
    } catch (InterruptedException ignored) {
      return false;
    } finally {
      System.out.format("%s: Finished %s %n", getName(), call);
    }
    return true;
  }
}
