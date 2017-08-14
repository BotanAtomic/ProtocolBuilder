package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightNoSpellCastMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int spellLevelId = 0;
  public static final int protocolId = 6132;

  public void serialize(ICustomDataOutput param1) {
    if (this.spellLevelId < 0) {
      throw new Exception("Forbidden value (" + this.spellLevelId + ") on element spellLevelId.");
    }
    param1.writeVarInt(this.spellLevelId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.spellLevelId = param1.readVarUhInt();
    if (this.spellLevelId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.spellLevelId
              + ") on element of GameActionFightNoSpellCastMessage.spellLevelId.");
    }
  }
}
