package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionObjectUse extends HumanOption implements INetworkType {

  public int delayTypeId = 0;
  public Number delayEndTime = 0;
  public int objectGID = 0;
  public static final int protocolId = 449;

  @Override
  public void serialize(ICustomDataOutput param1) {

    param1.writeByte(this.delayTypeId);
    if (this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.delayEndTime + ") on element delayEndTime.");
    }
    param1.writeDouble(this.delayEndTime);
    if (this.objectGID < 0) {
      throw new Error("Forbidden value (" + this.objectGID + ") on element objectGID.");
    }
    param1.writeVarShort(this.objectGID);
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

    this.delayTypeId = param1.readByte();
    if (this.delayTypeId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.delayTypeId
              + ") on element of HumanOptionObjectUse.delayTypeId.");
    }

    this.delayEndTime = param1.readDouble();
    if (this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.delayEndTime
              + ") on element of HumanOptionObjectUse.delayEndTime.");
    }

    this.objectGID = param1.readVarUhShort();
    if (this.objectGID < 0) {
      throw new Error(
          "Forbidden value ("
              + this.objectGID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectGID.");
    }
  }
}
