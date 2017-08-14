package com.ankamagames.dofus.network.messages.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayShowActorWithEventMessage extends GameRolePlayShowActorMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int actorEventId = 0;
  public static final int protocolId = 6407;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.informations.getTypeId());
    this.informations.serialize(param1);

    if (this.actorEventId < 0) {
      throw new Error("Forbidden value (" + this.actorEventId + ") on element actorEventId.");
    }
    param1.writeByte(this.actorEventId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.actorEventId = param1.readByte();
    if (this.actorEventId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.actorEventId
              + ") on element of GameRolePlayShowActorWithEventMessage.actorEventId.");
    }
  }
}
