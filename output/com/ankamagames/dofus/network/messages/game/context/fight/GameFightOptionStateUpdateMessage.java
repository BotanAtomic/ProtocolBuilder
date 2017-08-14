package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightOptionStateUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightId = 0;
  public int teamId = 2;
  public int option = 3;
  public boolean state = false;
  public static final int protocolId = 5927;

  public void serialize(ICustomDataOutput param1) {
    if (this.fightId < 0) {
      throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
    }
    param1.writeShort(this.fightId);
    param1.writeByte(this.teamId);
    param1.writeByte(this.option);
    param1.writeBoolean(this.state);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightId = param1.readInt();

    this.teamId = param1.readByte();
    if (this.teamId < 0) {
      throw new Exception(
          "Forbidden value (" + this.teamId + ") on element of NamedPartyTeam.teamId.");
    }

    this.option = param1.readByte();
    if (this.option < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.option
              + ") on element of GameFightOptionToggleMessage.option.");
    }

    this.state = param1.readByte();
    if (this.state < 0) {
      throw new Exception("Forbidden value (" + this.state + ") on element of ContentPart.state.");
    }
  }
}
