package com.ankamagames.dofus.network.types.game.character.characteristic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterSpellModification extends Object implements INetworkType {

  public int modificationType = 0;
  public int spellId = 0;
  public CharacterBaseCharacteristic value;
  private FuncTree _valuetree;
  public static final int protocolId = 215;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.modificationType);
    if (this.spellId < 0) {
      throw new Error("Forbidden value (" + this.spellId + ") on element spellId.");
    }
    param1.writeVarShort(this.spellId);
    this.value.serializeAs_CharacterBaseCharacteristic(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.modificationType = param1.readByte();
    if (this.modificationType < 0) {
      throw new Error(
          "Forbidden value ("
              + this.modificationType
              + ") on element of CharacterSpellModification.modificationType.");
    }

    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Error(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

    this.value = new CharacterBaseCharacteristic();
    this.value.deserialize(param1);
  }
}
