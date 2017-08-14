package com.ankamagames.dofus.network.messages.game.character.stats;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterLevelUpMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int newLevel = 0;
  public static final int protocolId = 5670;

  public void serialize(ICustomDataOutput param1) {
    if (this.newLevel < 2 || this.newLevel > 206) {
      throw new Error("Forbidden value (" + this.newLevel + ") on element newLevel.");
    }
    param1.writeByte(this.newLevel);
  }

  public void deserialize(ICustomDataInput param1) {
    this.newLevel = param1.readUnsignedByte();
    if (this.newLevel < 2 || this.newLevel > 200) {
      throw new Error(
          "Forbidden value (" + this.newLevel + ") on element of GuildLevelUpMessage.newLevel.");
    }
  }
}
