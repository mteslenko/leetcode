package cracking.ood.callcenter;

/**
 * Call.
 */
public class Call {
  private Person caller;
  private boolean isDifficult = false;
  private boolean isVeryDifficult = false;

  public static class Builder {
    private Person caller;
    private boolean isDifficult = false;
    private boolean isVeryDifficult = false;

    public Builder setCaller(Person caller) {
      this.caller = caller;
      return this;
    }

    public Builder setDifficult(boolean difficult) {
      isDifficult = difficult;
      return this;
    }

    public Builder setVeryDifficult(boolean veryDifficult) {
      isVeryDifficult = veryDifficult;
      return this;
    }

    public Call build() {
      if (caller == null) {
        throw new IllegalArgumentException("Caller is unknown");
      }

      Call call = new Call();
      call.caller = caller;
      call.isDifficult = isDifficult;
      call.isVeryDifficult = isVeryDifficult;
      return call;
    }
  }

  public boolean isDifficult() {
    return isDifficult;
  }

  public boolean isVeryDifficult() {
    return isVeryDifficult;
  }

  @Override
  public String toString() {
    if(isDifficult) {
      return String.format("Difficult call from %s", caller);
    }
    if(isVeryDifficult) {
      return String.format("Very difficult call from %s", caller);
    }
    return String.format("Call from %s", caller);
  }
}

