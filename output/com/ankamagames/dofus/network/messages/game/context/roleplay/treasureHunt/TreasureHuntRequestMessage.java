package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TreasureHuntRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int questLevel = 0;
  public int questType = 0;
  public static final int protocolId = 6488;

  public void serialize(ICustomDataOutput param1) {
    if (this.questLevel < 1 || this.questLevel > 206) {
      throw new Error("Forbidden value (" + this.questLevel + ") on element questLevel.");
    }
    param1.writeByte(this.questLevel);
    param1.writeByte(this.questType);
  }

  public void deserialize(ICustomDataInput param1) {
    this.questLevel = param1.readUnsignedByte();
    if (this.questLevel < 1 || this.questLevel > 206) {
      throw new Error(
          "Forbidden value ("
              + this.questLevel
              + ") on element of TreasureHuntRequestMessage.questLevel.");
    }

    this.questType = param1.readByte();
    if (this.questType < 0) {
      throw new Error(
          "Forbidden value ("
              + this.questType
              + ") on element of TreasureHuntRequestMessage.questType.");
    }
  }
}
