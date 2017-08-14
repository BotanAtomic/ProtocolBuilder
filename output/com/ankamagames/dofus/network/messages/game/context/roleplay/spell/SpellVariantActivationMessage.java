package com.ankamagames.dofus.network.messages.game.context.roleplay.spell;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SpellVariantActivationMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean result = false;
  public int activatedSpellId = 0;
  public int deactivatedSpellId = 0;
  public static final int protocolId = 6705;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.result);
    if (this.activatedSpellId < 0) {
      throw new Error(
          "Forbidden value (" + this.activatedSpellId + ") on element activatedSpellId.");
    }
    param1.writeVarShort(this.activatedSpellId);
    if (this.deactivatedSpellId < 0) {
      throw new Error(
          "Forbidden value (" + this.deactivatedSpellId + ") on element deactivatedSpellId.");
    }
    param1.writeVarShort(this.deactivatedSpellId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.result = param1.readByte();
    if (this.result < 0) {
      throw new Error(
          "Forbidden value (" + this.result + ") on element of GuildCreationResultMessage.result.");
    }

    this.activatedSpellId = param1.readVarUhShort();
    if (this.activatedSpellId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.activatedSpellId
              + ") on element of SpellVariantActivationMessage.activatedSpellId.");
    }

    this.deactivatedSpellId = param1.readVarUhShort();
    if (this.deactivatedSpellId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.deactivatedSpellId
              + ") on element of SpellVariantActivationMessage.deactivatedSpellId.");
    }
  }
}
