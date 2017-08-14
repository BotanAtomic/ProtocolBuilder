package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayPlayerFightFriendlyAnsweredMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightId = 0;
  public Number sourceId = 0;
  public Number targetId = 0;
  public boolean accept = false;
  public static final int protocolId = 5733;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.fightId);
    if (this.sourceId < 0 || this.sourceId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.sourceId + ") on element sourceId.");
    }
    param1.writeVarLong(this.sourceId);
    if (this.targetId < 0 || this.targetId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeVarLong(this.targetId);
    param1.writeBoolean(this.accept);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightId = param1.readInt();

    this.sourceId = param1.readDouble();
    if (this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.sourceId
              + ") on element of FightDispellableEffectExtendedInformations.sourceId.");
    }

    this.targetId = param1.readDouble();
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.targetId
              + ") on element of AbstractFightDispellableEffect.targetId.");
    }

    this.accept = param1.readBoolean();
  }
}
