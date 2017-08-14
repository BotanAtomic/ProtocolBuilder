package com.ankamagames.dofus.network.types.game.character;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterMinimalInformations extends CharacterBasicMinimalInformations
    implements INetworkType {

  public int level = 0;
  public static final int protocolId = 110;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);

    param1.writeUTF(this.name);

    if (this.level < 1 || this.level > 206) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
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

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }
  }
}
