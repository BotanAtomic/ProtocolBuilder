package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TreasureHuntFlagRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int questType = 0;
  public int index = 0;
  public static final int protocolId = 6508;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.questType);
    if (this.index < 0) {
      throw new Error("Forbidden value (" + this.index + ") on element index.");
    }
    param1.writeByte(this.index);
  }

  public void deserialize(ICustomDataInput param1) {
    this.questType = param1.readByte();
    if (this.questType < 0) {
      throw new Error(
          "Forbidden value ("
              + this.questType
              + ") on element of TreasureHuntRequestMessage.questType.");
    }

    this.index = param1.readByte();
    if (this.index < 0) {
      throw new Error(
          "Forbidden value (" + this.index + ") on element of IndexedEntityLook.index.");
    }
  }
}
