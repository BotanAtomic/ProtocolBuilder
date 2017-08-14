package com.ankamagames.dofus.network.types.game.data.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SpellItem extends Item implements INetworkType {

  public int spellId = 0;
  public int spellLevel = 0;
  public static final int protocolId = 49;

  @Override
  public void serialize(ICustomDataOutput param1) {

    param1.writeInt(this.spellId);
    if (this.spellLevel < 1 || this.spellLevel > 200) {
      throw new Error("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
    }
    param1.writeShort(this.spellLevel);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Error(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

    this.spellLevel = param1.readShort();
    if (this.spellLevel < 1 || this.spellLevel > 200) {
      throw new Error(
          "Forbidden value (" + this.spellLevel + ") on element of SpellItem.spellLevel.");
    }
  }
}
