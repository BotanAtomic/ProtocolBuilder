package com.ankamagames.dofus.network.messages.game.character.stats;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LifePointsRegenBeginMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int regenRate = 0;
  public static final int protocolId = 5684;

  public void serialize(ICustomDataOutput param1) {
    if (this.regenRate < 0 || this.regenRate > 255) {
      throw new Exception("Forbidden value (" + this.regenRate + ") on element regenRate.");
    }
    param1.writeByte(this.regenRate);
  }

  public void deserialize(ICustomDataInput param1) {
    this.regenRate = param1.readUnsignedByte();
    if (this.regenRate < 0 || this.regenRate > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.regenRate
              + ") on element of PartyMemberInformations.regenRate.");
    }
  }
}
