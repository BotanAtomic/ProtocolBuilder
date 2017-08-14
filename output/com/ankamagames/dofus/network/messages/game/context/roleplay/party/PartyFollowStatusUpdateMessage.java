package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class PartyFollowStatusUpdateMessage extends AbstractPartyMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean success = false;
  public boolean isFollowed = false;
  public Number followedId = 0;
  public static final int protocolId = 5581;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.success);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.isFollowed);
    param1.writeByte(_loc2_);
    if (this.followedId < 0 || this.followedId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.followedId + ") on element followedId.");
    }
    param1.writeVarLong(this.followedId);
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

    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.followedId = param1.readVarUhLong();
    if (this.followedId < 0 || this.followedId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.followedId
              + ") on element of PartyFollowStatusUpdateMessage.followedId.");
    }
  }
}
