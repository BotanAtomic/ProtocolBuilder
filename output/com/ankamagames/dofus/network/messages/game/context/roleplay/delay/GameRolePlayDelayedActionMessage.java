package com.ankamagames.dofus.network.messages.game.context.roleplay.delay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayDelayedActionMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number delayedCharacterId = 0;
  public int delayTypeId = 0;
  public Number delayEndTime = 0;
  public static final int protocolId = 6153;

  public void serialize(ICustomDataOutput param1) {
    if (this.delayedCharacterId < -9.007199254740992E15
        || this.delayedCharacterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.delayedCharacterId + ") on element delayedCharacterId.");
    }
    param1.writeDouble(this.delayedCharacterId);
    param1.writeByte(this.delayTypeId);
    if (this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.delayEndTime + ") on element delayEndTime.");
    }
    param1.writeDouble(this.delayEndTime);
  }

  public void deserialize(ICustomDataInput param1) {
    this.delayedCharacterId = param1.readDouble();
    if (this.delayedCharacterId < -9.007199254740992E15
        || this.delayedCharacterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.delayedCharacterId
              + ") on element of GameRolePlayDelayedActionMessage.delayedCharacterId.");
    }

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
  }
}
