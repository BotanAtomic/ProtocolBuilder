package com.ankamagames.dofus.network.messages.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildSpellUpgradeRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int spellId = 0;
  public static final int protocolId = 5699;

  public void serialize(ICustomDataOutput param1) {
    if (this.spellId < 0) {
      throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
    }
    param1.writeInt(this.spellId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Exception(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }
  }
}
