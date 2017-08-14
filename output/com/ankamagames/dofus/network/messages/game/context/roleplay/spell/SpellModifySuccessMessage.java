package com.ankamagames.dofus.network.messages.game.context.roleplay.spell;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SpellModifySuccessMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int spellId = 0;
  public int spellLevel = 0;
  public static final int protocolId = 6654;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.spellId);
    if (this.spellLevel < 1 || this.spellLevel > 200) {
      throw new Exception("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
    }
    param1.writeShort(this.spellLevel);
  }

  public void deserialize(ICustomDataInput param1) {
    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Exception(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

    this.spellLevel = param1.readShort();
    if (this.spellLevel < 1 || this.spellLevel > 200) {
      throw new Exception(
          "Forbidden value (" + this.spellLevel + ") on element of SpellItem.spellLevel.");
    }
  }
}
