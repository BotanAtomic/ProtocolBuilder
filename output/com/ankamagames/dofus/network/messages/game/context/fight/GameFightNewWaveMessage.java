package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightNewWaveMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int id = 0;
  public int teamId = 2;
  public int nbTurnBeforeNextWave = 0;
  public static final int protocolId = 6490;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeByte(this.id);
    param1.writeByte(this.teamId);
    param1.writeShort(this.nbTurnBeforeNextWave);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.teamId = param1.readByte();
    if (this.teamId < 0) {
      throw new Error("Forbidden value (" + this.teamId + ") on element of NamedPartyTeam.teamId.");
    }

    this.nbTurnBeforeNextWave = param1.readShort();
  }
}
