package com.ankamagames.dofus.network.messages.game.achievement;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementFinishedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int id = 0;
  public int finishedlevel = 0;
  public static final int protocolId = 6208;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);
    if (this.finishedlevel < 0 || this.finishedlevel > 206) {
      throw new Error("Forbidden value (" + this.finishedlevel + ") on element finishedlevel.");
    }
    param1.writeByte(this.finishedlevel);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.finishedlevel = param1.readUnsignedByte();
    if (this.finishedlevel < 0 || this.finishedlevel > 206) {
      throw new Error(
          "Forbidden value ("
              + this.finishedlevel
              + ") on element of AchievementRewardable.finishedlevel.");
    }
  }
}
