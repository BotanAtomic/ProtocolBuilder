package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceMembershipMessage extends AllianceJoinedMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 6390;

  @Override
  public void serialize(ICustomDataOutput param1) {
    this.allianceInfo.serializeAs_AllianceInformations(param1);
    param1.writeBoolean(this.enabled);
    if (this.leadingGuildId < 0) {
      throw new Error("Forbidden value (" + this.leadingGuildId + ") on element leadingGuildId.");
    }
    param1.writeVarInt(this.leadingGuildId);
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
  }
}
