package com.ankamagames.dofus.network.messages.connection;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class IdentificationSuccessMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String login = "";
  public String nickname = "";
  public int accountId = 0;
  public int communityId = 0;
  public boolean hasRights = false;
  public String secretQuestion = "";
  public Number accountCreation = 0;
  public Number subscriptionElapsedDuration = 0;
  public Number subscriptionEndDate = 0;
  public boolean wasAlreadyConnected = false;
  public int havenbagAvailableRoom = 0;
  public static final int protocolId = 22;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.hasRights);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.wasAlreadyConnected);
    param1.writeByte(_loc2_);
    param1.writeUTF(this.login);
    param1.writeUTF(this.nickname);
    if (this.accountId < 0) {
      throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    if (this.communityId < 0) {
      throw new Exception("Forbidden value (" + this.communityId + ") on element communityId.");
    }
    param1.writeByte(this.communityId);
    param1.writeUTF(this.secretQuestion);
    if (this.accountCreation < 0 || this.accountCreation > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.accountCreation + ") on element accountCreation.");
    }
    param1.writeDouble(this.accountCreation);
    if (this.subscriptionElapsedDuration < 0
        || this.subscriptionElapsedDuration > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.subscriptionElapsedDuration
              + ") on element subscriptionElapsedDuration.");
    }
    param1.writeDouble(this.subscriptionElapsedDuration);
    if (this.subscriptionEndDate < 0 || this.subscriptionEndDate > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.subscriptionEndDate + ") on element subscriptionEndDate.");
    }
    param1.writeDouble(this.subscriptionEndDate);
    if (this.havenbagAvailableRoom < 0 || this.havenbagAvailableRoom > 255) {
      throw new Exception(
          "Forbidden value (" + this.havenbagAvailableRoom + ") on element havenbagAvailableRoom.");
    }
    param1.writeByte(this.havenbagAvailableRoom);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.login = param1.readUTF();

    this.nickname = param1.readUTF();

    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Exception(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }

    this.communityId = param1.readShort();

    this.secretQuestion = param1.readUTF();

    this.accountCreation = param1.readDouble();
    if (this.accountCreation < 0 || this.accountCreation > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.accountCreation
              + ") on element of IdentificationSuccessMessage.accountCreation.");
    }

    this.subscriptionElapsedDuration = param1.readDouble();
    if (this.subscriptionElapsedDuration < 0
        || this.subscriptionElapsedDuration > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.subscriptionElapsedDuration
              + ") on element of IdentificationSuccessMessage.subscriptionElapsedDuration.");
    }

    this.subscriptionEndDate = param1.readDouble();
    if (this.subscriptionEndDate < 0 || this.subscriptionEndDate > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.subscriptionEndDate
              + ") on element of IdentificationSuccessMessage.subscriptionEndDate.");
    }

    this.havenbagAvailableRoom = param1.readUnsignedByte();
    if (this.havenbagAvailableRoom < 0 || this.havenbagAvailableRoom > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.havenbagAvailableRoom
              + ") on element of IdentificationSuccessMessage.havenbagAvailableRoom.");
    }
  }
}
