package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyInvitationDungeonRequestMessage extends PartyInvitationRequestMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int dungeonId = 0;
  public static final int protocolId = 6245;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.name);

    if (this.dungeonId < 0) {
      throw new Error("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
    }
    param1.writeVarShort(this.dungeonId);
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

    this.dungeonId = param1.readVarUhShort();
    if (this.dungeonId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.dungeonId
              + ") on element of TeleportToBuddyOfferMessage.dungeonId.");
    }
  }
}
