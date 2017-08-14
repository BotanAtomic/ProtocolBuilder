package com.ankamagames.dofus.network.types.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AbstractFightDispellableEffect extends Object implements INetworkType {

  public int uid = 0;
  public Number targetId = 0;
  public int turnDuration = 0;
  public int dispelable = 1;
  public int spellId = 0;
  public int effectId = 0;
  public int parentBoostUid = 0;
  public static final int protocolId = 206;

  public void serialize(ICustomDataOutput param1) {
    if (this.uid < 0) {
      throw new Error("Forbidden value (" + this.uid + ") on element uid.");
    }
    param1.writeVarInt(this.uid);
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeDouble(this.targetId);
    param1.writeShort(this.turnDuration);
    param1.writeByte(this.dispelable);
    if (this.spellId < 0) {
      throw new Error("Forbidden value (" + this.spellId + ") on element spellId.");
    }
    param1.writeVarShort(this.spellId);
    if (this.effectId < 0) {
      throw new Error("Forbidden value (" + this.effectId + ") on element effectId.");
    }
    param1.writeVarInt(this.effectId);
    if (this.parentBoostUid < 0) {
      throw new Error("Forbidden value (" + this.parentBoostUid + ") on element parentBoostUid.");
    }
    param1.writeVarInt(this.parentBoostUid);
  }

  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.targetId = param1.readDouble();
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.targetId
              + ") on element of AbstractFightDispellableEffect.targetId.");
    }

    this.turnDuration = param1.readShort();

    this.dispelable = param1.readByte();
    if (this.dispelable < 0) {
      throw new Error(
          "Forbidden value ("
              + this.dispelable
              + ") on element of AbstractFightDispellableEffect.dispelable.");
    }

    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Error(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

    this.effectId = param1.readVarUhInt();
    if (this.effectId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.effectId
              + ") on element of AbstractFightDispellableEffect.effectId.");
    }

    this.parentBoostUid = param1.readVarUhInt();
    if (this.parentBoostUid < 0) {
      throw new Error(
          "Forbidden value ("
              + this.parentBoostUid
              + ") on element of AbstractFightDispellableEffect.parentBoostUid.");
    }
  }
}
