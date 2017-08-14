package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class EmotePlayMessage extends EmotePlayAbstractMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number actorId = 0;
  public int accountId = 0;
  public static final int protocolId = 5683;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.emoteId < 0 || this.emoteId > 255) {
      throw new Exception("Forbidden value (" + this.emoteId + ") on element emoteId.");
    }
    param1.writeByte(this.emoteId);
    if (this.emoteStartTime < -9.007199254740992E15 || this.emoteStartTime > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.emoteStartTime + ") on element emoteStartTime.");
    }
    param1.writeDouble(this.emoteStartTime);

    if (this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.actorId + ") on element actorId.");
    }
    param1.writeDouble(this.actorId);
    if (this.accountId < 0) {
      throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
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

    this.actorId = param1.readDouble();
    if (this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.actorId
              + ") on element of SetCharacterRestrictionsMessage.actorId.");
    }

    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Exception(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }
  }
}
