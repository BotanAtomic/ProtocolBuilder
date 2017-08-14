package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationSuccessWithLoginTokenMessage extends IdentificationSuccessMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public String loginToken = "";
  public static final int protocolId = 6209;

  @Override
  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.hasRights);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.wasAlreadyConnected);
    param1.writeByte(_loc2_);
    param1.writeUTF(this.login);
    param1.writeUTF(this.nickname);
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    if (this.communityId < 0) {
      throw new Error("Forbidden value (" + this.communityId + ") on element communityId.");
    }
    param1.writeByte(this.communityId);
    param1.writeUTF(this.secretQuestion);
    if (this.accountCreation < 0 || this.accountCreation > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.accountCreation + ") on element accountCreation.");
    }
    param1.writeDouble(this.accountCreation);
    if (this.subscriptionElapsedDuration < 0
        || this.subscriptionElapsedDuration > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.subscriptionElapsedDuration
              + ") on element subscriptionElapsedDuration.");
    }
    param1.writeDouble(this.subscriptionElapsedDuration);
    if (this.subscriptionEndDate < 0 || this.subscriptionEndDate > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.subscriptionEndDate + ") on element subscriptionEndDate.");
    }
    param1.writeDouble(this.subscriptionEndDate);
    if (this.havenbagAvailableRoom < 0 || this.havenbagAvailableRoom > 255) {
      throw new Error(
          "Forbidden value (" + this.havenbagAvailableRoom + ") on element havenbagAvailableRoom.");
    }
    param1.writeByte(this.havenbagAvailableRoom);

    param1.writeUTF(this.loginToken);
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

    this.loginToken = param1.readUTF();
  }
}
