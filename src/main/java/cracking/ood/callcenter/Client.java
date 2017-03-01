package cracking.ood.callcenter;

import cracking.ood.callcenter.Call.Builder;

public class Client {

  public static void main(String[] args) {
    CallCenter callCenter = new CallCenter();
    callCenter.start();
    callCenter.accept(new Builder().setCaller(new Person("Client 1")).build());
    callCenter.accept(new Builder().setCaller(new Person("Client 2")).setDifficult(true).build());
    callCenter.accept(new Builder().setCaller(new Person("Client 3"))
        .setVeryDifficult(true)
        .build());
    callCenter.accept(new Builder().setCaller(new Person("Client 4")).build());
    callCenter.accept(new Builder().setCaller(new Person("Client 5")).setDifficult(true).build());
    callCenter.accept(new Builder().setCaller(new Person("Client 6")).build());
    callCenter.accept(new Builder().setCaller(new Person("Client 7")).setDifficult(true).build());
    callCenter.stop();
  }


}
