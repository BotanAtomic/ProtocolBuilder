package com.ankamagames.dofus.network.messages.game.context.roleplay.purchasable;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class PurchasableDialogMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean buyOrSell = false;
  public int purchasableId = 0;
  public int purchasableInstanceId = 0;
  public boolean secondHand = false;
  public Number price = 0;
  public static final int protocolId = 5739;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.buyOrSell);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.secondHand);
    param1.writeByte(_loc2_);
    if (this.purchasableId < 0) {
      throw new Exception("Forbidden value (" + this.purchasableId + ") on element purchasableId.");
    }
    param1.writeVarInt(this.purchasableId);
    if (this.purchasableInstanceId < 0) {
      throw new Exception(
          "Forbidden value (" + this.purchasableInstanceId + ") on element purchasableInstanceId.");
    }
    param1.writeInt(this.purchasableInstanceId);
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.price + ") on element price.");
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

    this.purchasableId = param1.readVarUhInt();
    if (this.purchasableId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.purchasableId
              + ") on element of PurchasableDialogMessage.purchasableId.");
    }

    this.purchasableInstanceId = param1.readInt();
    if (this.purchasableInstanceId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.purchasableInstanceId
              + ") on element of PurchasableDialogMessage.purchasableInstanceId.");
    }

    this.price = param1.readVarUhLong();
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.price + ") on element of PaddockInformationsForSell.price.");
    }
  }
}
