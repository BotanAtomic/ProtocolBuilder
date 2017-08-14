package com.ankamagames.dofus.network.messages.game.initialization;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterCapabilitiesMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int guildEmblemSymbolCategories = 0;
  public static final int protocolId = 6339;

  public void serialize(ICustomDataOutput param1) {
    if (this.guildEmblemSymbolCategories < 0) {
      throw new Error(
          "Forbidden value ("
              + this.guildEmblemSymbolCategories
              + ") on element guildEmblemSymbolCategories.");
    }
    param1.writeVarInt(this.guildEmblemSymbolCategories);
  }

  public void deserialize(ICustomDataInput param1) {
    this.guildEmblemSymbolCategories = param1.readVarUhInt();
    if (this.guildEmblemSymbolCategories < 0) {
      throw new Error(
          "Forbidden value ("
              + this.guildEmblemSymbolCategories
              + ") on element of CharacterCapabilitiesMessage.guildEmblemSymbolCategories.");
    }
  }
}
