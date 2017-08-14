package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildMembershipMessage extends GuildJoinedMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 5835;

  @Override
  public void serialize(ICustomDataOutput param1) {
    this.guildInfo.serializeAs_GuildInformations(param1);
    if (this.memberRights < 0) {
      throw new Exception("Forbidden value (" + this.memberRights + ") on element memberRights.");
    }
    param1.writeVarInt(this.memberRights);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();
  }
}
