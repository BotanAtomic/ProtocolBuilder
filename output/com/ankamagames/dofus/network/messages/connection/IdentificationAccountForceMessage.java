package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.version.VersionExtended;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationAccountForceMessage extends IdentificationMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public String forcedAccountLogin = "";
  public static final int protocolId = 6119;

  @Override
  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.autoconnect);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.useCertificate);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.useLoginToken);
    param1.writeByte(_loc2_);
    this.version.serializeAs_VersionExtended(param1);
    param1.writeUTF(this.lang);
    param1.writeVarInt(this.credentials.length);
    int _loc3_ = 0;
    while (_loc3_ < this.credentials.length) {
      param1.writeByte(this.credentials[_loc3_]);
      _loc3_++;
    }
    param1.writeShort(this.serverId);
    if (this.sessionOptionalSalt < -9.007199254740992E15
        || this.sessionOptionalSalt > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.sessionOptionalSalt + ") on element sessionOptionalSalt.");
    }
    param1.writeVarLong(this.sessionOptionalSalt);
    param1.writeShort(this.failedAttempts.length);
    int _loc4_ = 0;
    while (_loc4_ < this.failedAttempts.length) {
      if (this.failedAttempts[_loc4_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.failedAttempts[_loc4_]
                + ") on element 9 (starting at 1) of failedAttempts.");
      }
      param1.writeVarShort(this.failedAttempts[_loc4_]);
      _loc4_++;
    }

    param1.writeUTF(this.forcedAccountLogin);
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

    this.forcedAccountLogin = param1.readUTF();
  }
}
