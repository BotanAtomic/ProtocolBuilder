package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightCastRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int spellId = 0;
  public int cellId = 0;
  public static final int protocolId = 1005;

  public void serialize(ICustomDataOutput param1) {
    if (this.spellId < 0) {
      throw new Error("Forbidden value (" + this.spellId + ") on element spellId.");
    }
    param1.writeVarShort(this.spellId);
    if (this.cellId < -1 || this.cellId > 559) {
      throw new Error("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeShort(this.cellId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Error(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

    this.cellId = param1.readVarUhShort();
    if (this.cellId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.cellId
              + ") on element of HavenBagFurnitureInformation.cellId.");
    }
  }
}
