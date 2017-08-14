package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseToSellFilterMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int areaId = 0;
  public int atLeastNbRoom = 0;
  public int atLeastNbChest = 0;
  public int skillRequested = 0;
  public Number maxPrice = 0;
  public static final int protocolId = 6137;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.areaId);
    if (this.atLeastNbRoom < 0) {
      throw new Error("Forbidden value (" + this.atLeastNbRoom + ") on element atLeastNbRoom.");
    }
    param1.writeByte(this.atLeastNbRoom);
    if (this.atLeastNbChest < 0) {
      throw new Error("Forbidden value (" + this.atLeastNbChest + ") on element atLeastNbChest.");
    }
    param1.writeByte(this.atLeastNbChest);
    if (this.skillRequested < 0) {
      throw new Error("Forbidden value (" + this.skillRequested + ") on element skillRequested.");
    }
    param1.writeVarShort(this.skillRequested);
    if (this.maxPrice < 0 || this.maxPrice > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.maxPrice + ") on element maxPrice.");
    }
    param1.writeVarLong(this.maxPrice);
  }

  public void deserialize(ICustomDataInput param1) {
    this.areaId = param1.readShort();

    this.atLeastNbRoom = param1.readByte();
    if (this.atLeastNbRoom < 0) {
      throw new Error(
          "Forbidden value ("
              + this.atLeastNbRoom
              + ") on element of HouseToSellFilterMessage.atLeastNbRoom.");
    }

    this.atLeastNbChest = param1.readByte();
    if (this.atLeastNbChest < 0) {
      throw new Error(
          "Forbidden value ("
              + this.atLeastNbChest
              + ") on element of HouseToSellFilterMessage.atLeastNbChest.");
    }

    this.skillRequested = param1.readVarUhShort();
    if (this.skillRequested < 0) {
      throw new Error(
          "Forbidden value ("
              + this.skillRequested
              + ") on element of HouseToSellFilterMessage.skillRequested.");
    }

    this.maxPrice = param1.readVarUhLong();
    if (this.maxPrice < 0 || this.maxPrice > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.maxPrice
              + ") on element of PaddockToSellFilterMessage.maxPrice.");
    }
  }
}
