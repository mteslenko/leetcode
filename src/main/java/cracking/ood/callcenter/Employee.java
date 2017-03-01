package cracking.ood.callcenter;

public abstract class Employee extends Person {
  protected Employee(String name) {
    super(name);
  }

  abstract boolean handleCall(Call call);

}
