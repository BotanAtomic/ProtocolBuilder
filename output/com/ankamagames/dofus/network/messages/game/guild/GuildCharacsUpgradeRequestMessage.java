package com.ankamagames.dofus.network.messages.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildCharacsUpgradeRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int charaTypeTarget = 0;
  public static final int protocolId = 5706;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.charaTypeTarget);
  }

  public void deserialize(ICustomDataInput param1) {
    this.charaTypeTarget = param1.readByte();
    if (this.charaTypeTarget < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.charaTypeTarget
              + ") on element of GuildCharacsUpgradeRequestMessage.charaTypeTarget.");
    }
  }
}
