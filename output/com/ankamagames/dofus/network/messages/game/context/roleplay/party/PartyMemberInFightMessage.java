package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.MapCoordinatesExtended;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyMemberInFightMessage extends AbstractPartyMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int reason = 0;
  public Number memberId = 0;
  public int memberAccountId = 0;
  public String memberName = "";
  public int fightId = 0;
  public MapCoordinatesExtended fightMap;
  public int timeBeforeFightStart = 0;
  private FuncTree _fightMaptree;
  public static final int protocolId = 6342;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Error("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    param1.writeByte(this.reason);
    if (this.memberId < 0 || this.memberId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.memberId + ") on element memberId.");
    }
    param1.writeVarLong(this.memberId);
    if (this.memberAccountId < 0) {
      throw new Error("Forbidden value (" + this.memberAccountId + ") on element memberAccountId.");
    }
    param1.writeInt(this.memberAccountId);
    param1.writeUTF(this.memberName);
    param1.writeInt(this.fightId);
    this.fightMap.serializeAs_MapCoordinatesExtended(param1);
    param1.writeVarShort(this.timeBeforeFightStart);
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

    this.reason = param1.readByte();
    if (this.reason < 0) {
      throw new Error(
          "Forbidden value ("
              + this.reason
              + ") on element of KrosmasterInventoryErrorMessage.reason.");
    }

    this.memberId = param1.readInt();
    if (this.memberId < 0) {
      throw new Error(
          "Forbidden value (" + this.memberId + ") on element of PartyMemberGeoPosition.memberId.");
    }

    this.memberAccountId = param1.readInt();
    if (this.memberAccountId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.memberAccountId
              + ") on element of PartyMemberInFightMessage.memberAccountId.");
    }

    this.memberName = param1.readUTF();

    this.fightId = param1.readInt();

    this.fightMap = new MapCoordinatesExtended();
    this.fightMap.deserialize(param1);
    this.timeBeforeFightStart = param1.readVarShort();
  }
}
