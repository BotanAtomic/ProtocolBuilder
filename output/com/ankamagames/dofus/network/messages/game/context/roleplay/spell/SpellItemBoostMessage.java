package com.ankamagames.dofus.network.messages.game.context.roleplay.spell;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SpellItemBoostMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int statId = 0;
  public int spellId = 0;
  public int value = 0;
  public static final int protocolId = 6011;

  public void serialize(ICustomDataOutput param1) {
    if (this.statId < 0) {
      throw new Error("Forbidden value (" + this.statId + ") on element statId.");
    }
    param1.writeVarInt(this.statId);
    if (this.spellId < 0) {
      throw new Error("Forbidden value (" + this.spellId + ") on element spellId.");
    }
    param1.writeVarShort(this.spellId);
    param1.writeVarShort(this.value);
  }

  public void deserialize(ICustomDataInput param1) {
    this.statId = param1.readByte();
    if (this.statId < 0) {
      throw new Error(
          "Forbidden value (" + this.statId + ") on element of StatsUpgradeRequestMessage.statId.");
    }

    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Error(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

    this.value = param1.readInt();
  }
}
