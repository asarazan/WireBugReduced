// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ././reduced_test.proto
package com.levelmoney.proto.reducedTest.updated;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

import static com.squareup.wire.Message.Datatype.STRING;
import static com.squareup.wire.Message.Label.REPEATED;

public final class Version2 extends Message {
  private static final long serialVersionUID = 0L;

  public static final List<String> DEFAULT_NEWFIELDS = Collections.emptyList();

  @ProtoField(tag = 1, type = STRING, label = REPEATED)
  public final List<String> newFields;

  public Version2(List<String> newFields) {
    this.newFields = immutableCopyOf(newFields);
  }

  private Version2(Builder builder) {
    this(builder.newFields);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Version2)) return false;
    return equals(newFields, ((Version2) other).newFields);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    return result != 0 ? result : (hashCode = newFields != null ? newFields.hashCode() : 1);
  }

  public static final class Builder extends Message.Builder<Version2> {

    public List<String> newFields;

    public Builder() {
    }

    public Builder(Version2 message) {
      super(message);
      if (message == null) return;
      this.newFields = copyOf(message.newFields);
    }

    public Builder newFields(List<String> newFields) {
      this.newFields = checkForNulls(newFields);
      return this;
    }

    @Override
    public Version2 build() {
      return new Version2(this);
    }
  }
}
