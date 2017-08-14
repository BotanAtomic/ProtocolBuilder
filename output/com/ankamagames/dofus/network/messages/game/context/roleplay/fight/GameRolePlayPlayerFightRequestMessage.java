package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayPlayerFightRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number targetId = 0;
  public int targetCellId = 0;
  public boolean friendly = false;
  public static final int protocolId = 5731;

  public void serialize(ICustomDataOutput param1) {
    if (this.targetId < 0 || this.targetId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeVarLong(this.targetId);
    if (this.targetCellId < -1 || this.targetCellId > 559) {
      throw new Exception("Forbidden value (" + this.targetCellId + ") on element targetCellId.");
    }
    param1.writeShort(this.targetCellId);
    param1.writeBoolean(this.friendly);
  }

  public void deserialize(ICustomDataInput param1) {
    this.targetId = param1.readDouble();
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.targetId
              + ") on element of AbstractFightDispellableEffect.targetId.");
    }

    this.targetCellId = param1.readVarUhShort();
    if (this.targetCellId < 0 || this.targetCellId > 559) {
      throw new Exception(
          "Forbidden value ("
              + this.targetCellId
              + ") on element of GameRolePlaySpellAnimMessage.targetCellId.");
    }

    this.friendly = param1.readBoolean();
  }
}
