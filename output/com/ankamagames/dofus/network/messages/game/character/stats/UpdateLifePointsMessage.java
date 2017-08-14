package com.ankamagames.dofus.network.messages.game.character.stats;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class UpdateLifePointsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int lifePoints = 0;
  public int maxLifePoints = 0;
  public static final int protocolId = 5658;

  public void serialize(ICustomDataOutput param1) {
    if (this.lifePoints < 0) {
      throw new Error("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
    }
    param1.writeVarInt(this.lifePoints);
    if (this.maxLifePoints < 0) {
      throw new Error("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
    }
    param1.writeVarInt(this.maxLifePoints);
  }

  public void deserialize(ICustomDataInput param1) {
    this.lifePoints = param1.readVarUhInt();
    if (this.lifePoints < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lifePoints
              + ") on element of PartyMemberInformations.lifePoints.");
    }

    this.maxLifePoints = param1.readVarUhInt();
    if (this.maxLifePoints < 0) {
      throw new Error(
          "Forbidden value ("
              + this.maxLifePoints
              + ") on element of PartyMemberInformations.maxLifePoints.");
    }
  }
}
