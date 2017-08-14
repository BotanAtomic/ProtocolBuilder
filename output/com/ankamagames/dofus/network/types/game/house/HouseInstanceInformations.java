package com.ankamagames.dofus.network.types.game.house;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseInstanceInformations extends Object implements INetworkType {

  public int instanceId = 0;
  public boolean secondHand = false;
  public boolean isLocked = false;
  public String ownerName = "";
  public Number price = 0;
  public boolean isSaleLocked = false;
  public static final int protocolId = 511;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.secondHand);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.isLocked);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.isSaleLocked);
    param1.writeByte(_loc2_);
    if (this.instanceId < 0) {
      throw new Error("Forbidden value (" + this.instanceId + ") on element instanceId.");
    }
    param1.writeInt(this.instanceId);
    param1.writeUTF(this.ownerName);
    if (this.price < -9.007199254740992E15 || this.price > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.price + ") on element price.");
    }
    param1.writeVarLong(this.price);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.instanceId = param1.readInt();
    if (this.instanceId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.instanceId
              + ") on element of HouseInstanceInformations.instanceId.");
    }

    this.ownerName = param1.readUTF();

    this.price = param1.readVarUhLong();
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.price + ") on element of PaddockInformationsForSell.price.");
    }
  }
}
