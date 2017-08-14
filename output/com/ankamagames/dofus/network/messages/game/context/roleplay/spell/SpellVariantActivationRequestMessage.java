package com.ankamagames.dofus.network.messages.game.context.roleplay.spell;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SpellVariantActivationRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int spellId = 0;
  public static final int protocolId = 6707;

  public void serialize(ICustomDataOutput param1) {
    if (this.spellId < 0) {
      throw new Error("Forbidden value (" + this.spellId + ") on element spellId.");
    }
    param1.writeVarShort(this.spellId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Error(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }
  }
}
