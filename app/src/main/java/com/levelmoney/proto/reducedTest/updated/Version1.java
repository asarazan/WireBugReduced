// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ././reduced_test.proto
package com.levelmoney.proto.reducedTest.updated;

import com.squareup.wire.Message;

public final class Version1 extends Message {
  private static final long serialVersionUID = 0L;

  public Version1() {
  }

  private Version1(Builder builder) {
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof Version1;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public static final class Builder extends Message.Builder<Version1> {

    public Builder() {
    }

    public Builder(Version1 message) {
      super(message);
    }

    @Override
    public Version1 build() {
      return new Version1(this);
    }
  }
}
