package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartedWithPodsMessage extends ExchangeStartedMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number firstCharacterId = 0;
  public int firstCharacterCurrentWeight = 0;
  public int firstCharacterMaxWeight = 0;
  public Number secondCharacterId = 0;
  public int secondCharacterCurrentWeight = 0;
  public int secondCharacterMaxWeight = 0;
  public static final int protocolId = 6129;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.exchangeType);

    if (this.firstCharacterId < -9.007199254740992E15
        || this.firstCharacterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.firstCharacterId + ") on element firstCharacterId.");
    }
    param1.writeDouble(this.firstCharacterId);
    if (this.firstCharacterCurrentWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.firstCharacterCurrentWeight
              + ") on element firstCharacterCurrentWeight.");
    }
    param1.writeVarInt(this.firstCharacterCurrentWeight);
    if (this.firstCharacterMaxWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.firstCharacterMaxWeight
              + ") on element firstCharacterMaxWeight.");
    }
    param1.writeVarInt(this.firstCharacterMaxWeight);
    if (this.secondCharacterId < -9.007199254740992E15
        || this.secondCharacterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.secondCharacterId + ") on element secondCharacterId.");
    }
    param1.writeDouble(this.secondCharacterId);
    if (this.secondCharacterCurrentWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.secondCharacterCurrentWeight
              + ") on element secondCharacterCurrentWeight.");
    }
    param1.writeVarInt(this.secondCharacterCurrentWeight);
    if (this.secondCharacterMaxWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.secondCharacterMaxWeight
              + ") on element secondCharacterMaxWeight.");
    }
    param1.writeVarInt(this.secondCharacterMaxWeight);
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

    this.firstCharacterId = param1.readDouble();
    if (this.firstCharacterId < -9.007199254740992E15
        || this.firstCharacterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.firstCharacterId
              + ") on element of ExchangeStartedWithPodsMessage.firstCharacterId.");
    }

    this.firstCharacterCurrentWeight = param1.readVarUhInt();
    if (this.firstCharacterCurrentWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.firstCharacterCurrentWeight
              + ") on element of ExchangeStartedWithPodsMessage.firstCharacterCurrentWeight.");
    }

    this.firstCharacterMaxWeight = param1.readVarUhInt();
    if (this.firstCharacterMaxWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.firstCharacterMaxWeight
              + ") on element of ExchangeStartedWithPodsMessage.firstCharacterMaxWeight.");
    }

    this.secondCharacterId = param1.readDouble();
    if (this.secondCharacterId < -9.007199254740992E15
        || this.secondCharacterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.secondCharacterId
              + ") on element of ExchangeStartedWithPodsMessage.secondCharacterId.");
    }

    this.secondCharacterCurrentWeight = param1.readVarUhInt();
    if (this.secondCharacterCurrentWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.secondCharacterCurrentWeight
              + ") on element of ExchangeStartedWithPodsMessage.secondCharacterCurrentWeight.");
    }

    this.secondCharacterMaxWeight = param1.readVarUhInt();
    if (this.secondCharacterMaxWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.secondCharacterMaxWeight
              + ") on element of ExchangeStartedWithPodsMessage.secondCharacterMaxWeight.");
    }
  }
}
