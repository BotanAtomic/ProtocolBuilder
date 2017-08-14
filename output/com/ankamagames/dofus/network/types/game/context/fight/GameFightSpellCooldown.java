package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightSpellCooldown extends Object implements INetworkType {

  public int spellId = 0;
  public int cooldown = 0;
  public static final int protocolId = 205;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.spellId);
    if (this.cooldown < 0) {
      throw new Exception("Forbidden value (" + this.cooldown + ") on element cooldown.");
    }
    param1.writeByte(this.cooldown);
  }

  public void deserialize(ICustomDataInput param1) {
    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Exception(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

    this.cooldown = param1.readByte();
    if (this.cooldown < 0) {
      throw new Exception(
          "Forbidden value (" + this.cooldown + ") on element of GameFightSpellCooldown.cooldown.");
    }
  }
}
