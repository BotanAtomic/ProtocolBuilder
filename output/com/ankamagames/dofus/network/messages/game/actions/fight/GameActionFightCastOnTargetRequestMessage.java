package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightCastOnTargetRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int spellId = 0;
  public Number targetId = 0;
  public static final int protocolId = 6330;

  public void serialize(ICustomDataOutput param1) {
    if (this.spellId < 0) {
      throw new Error("Forbidden value (" + this.spellId + ") on element spellId.");
    }
    param1.writeVarShort(this.spellId);
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeDouble(this.targetId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Error(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

    this.targetId = param1.readDouble();
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.targetId
              + ") on element of AbstractFightDispellableEffect.targetId.");
    }
  }
}
