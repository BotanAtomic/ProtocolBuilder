package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyUpdateLightMessage extends AbstractPartyEventMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number id = 0;
  public int lifePoints = 0;
  public int maxLifePoints = 0;
  public int prospecting = 0;
  public int regenRate = 0;
  public static final int protocolId = 6054;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);
    if (this.lifePoints < 0) {
      throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
    }
    param1.writeVarInt(this.lifePoints);
    if (this.maxLifePoints < 0) {
      throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
    }
    param1.writeVarInt(this.maxLifePoints);
    if (this.prospecting < 0) {
      throw new Exception("Forbidden value (" + this.prospecting + ") on element prospecting.");
    }
    param1.writeVarShort(this.prospecting);
    if (this.regenRate < 0 || this.regenRate > 255) {
      throw new Exception("Forbidden value (" + this.regenRate + ") on element regenRate.");
    }
    param1.writeByte(this.regenRate);
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

    this.id = param1.readUTF();

    this.lifePoints = param1.readVarUhInt();
    if (this.lifePoints < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.lifePoints
              + ") on element of PartyMemberInformations.lifePoints.");
    }

    this.maxLifePoints = param1.readVarUhInt();
    if (this.maxLifePoints < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.maxLifePoints
              + ") on element of PartyMemberInformations.maxLifePoints.");
    }

    this.prospecting = param1.readVarUhShort();
    if (this.prospecting < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.prospecting
              + ") on element of PartyMemberInformations.prospecting.");
    }

    this.regenRate = param1.readUnsignedByte();
    if (this.regenRate < 0 || this.regenRate > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.regenRate
              + ") on element of PartyMemberInformations.regenRate.");
    }
  }
}
