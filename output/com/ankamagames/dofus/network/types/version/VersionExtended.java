package com.ankamagames.dofus.network.types.version;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class VersionExtended extends Version implements INetworkType {

  public int install = 0;
  public int technology = 0;
  public static final int protocolId = 393;

  @Override
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

    param1.writeByte(this.install);
    param1.writeByte(this.technology);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.install = param1.readByte();
    if (this.install < 0) {
      throw new Error(
          "Forbidden value (" + this.install + ") on element of VersionExtended.install.");
    }

    this.technology = param1.readByte();
    if (this.technology < 0) {
      throw new Error(
          "Forbidden value (" + this.technology + ") on element of VersionExtended.technology.");
    }
  }
}
