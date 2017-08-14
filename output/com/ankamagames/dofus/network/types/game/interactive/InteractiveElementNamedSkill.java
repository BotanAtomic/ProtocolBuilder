package com.ankamagames.dofus.network.types.game.interactive;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveElementNamedSkill extends InteractiveElementSkill implements INetworkType {

  public int nameId = 0;
  public static final int protocolId = 220;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.skillId < 0) {
      throw new Error("Forbidden value (" + this.skillId + ") on element skillId.");
    }
    param1.writeVarInt(this.skillId);
    if (this.skillInstanceUid < 0) {
      throw new Error(
          "Forbidden value (" + this.skillInstanceUid + ") on element skillInstanceUid.");
    }
    param1.writeInt(this.skillInstanceUid);

    if (this.nameId < 0) {
      throw new Error("Forbidden value (" + this.nameId + ") on element nameId.");
    }
    param1.writeVarInt(this.nameId);
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

    this.nameId = param1.readVarUhInt();
    if (this.nameId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.nameId
              + ") on element of InteractiveElementNamedSkill.nameId.");
    }
  }
}
