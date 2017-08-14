package com.ankamagames.dofus.network.types.version;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class Version extends Object implements INetworkType {

  public int major = 0;
  public int minor = 0;
  public int release = 0;
  public int revision = 0;
  public int patch = 0;
  public int buildType = 0;
  public static final int protocolId = 11;

  public void serialize(ICustomDataOutput param1) {
    if (this.major < 0) {
      throw new Error("Forbidden value (" + this.major + ") on element major.");
    }
    param1.writeByte(this.major);
    if (this.minor < 0) {
      throw new Error("Forbidden value (" + this.minor + ") on element minor.");
    }
    param1.writeByte(this.minor);
    if (this.release < 0) {
      throw new Error("Forbidden value (" + this.release + ") on element release.");
    }
    param1.writeByte(this.release);
    if (this.revision < 0) {
      throw new Error("Forbidden value (" + this.revision + ") on element revision.");
    }
    param1.writeInt(this.revision);
    if (this.patch < 0) {
      throw new Error("Forbidden value (" + this.patch + ") on element patch.");
    }
    param1.writeByte(this.patch);
    param1.writeByte(this.buildType);
  }

  public void deserialize(ICustomDataInput param1) {
    this.major = param1.readByte();
    if (this.major < 0) {
      throw new Error("Forbidden value (" + this.major + ") on element of Version.major.");
    }

    this.minor = param1.readByte();
    if (this.minor < 0) {
      throw new Error("Forbidden value (" + this.minor + ") on element of Version.minor.");
    }

    this.release = param1.readByte();
    if (this.release < 0) {
      throw new Error("Forbidden value (" + this.release + ") on element of Version.release.");
    }

    this.revision = param1.readInt();
    if (this.revision < 0) {
      throw new Error("Forbidden value (" + this.revision + ") on element of Version.revision.");
    }

    this.patch = param1.readByte();
    if (this.patch < 0) {
      throw new Error("Forbidden value (" + this.patch + ") on element of Version.patch.");
    }

    this.buildType = param1.readByte();
    if (this.buildType < 0) {
      throw new Error("Forbidden value (" + this.buildType + ") on element of Version.buildType.");
    }
  }
}
