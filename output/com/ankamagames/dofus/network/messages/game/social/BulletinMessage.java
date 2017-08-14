package com.ankamagames.dofus.network.messages.game.social;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BulletinMessage extends SocialNoticeMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int lastNotifiedTimestamp = 0;
  public static final int protocolId = 6695;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.content);
    if (this.timestamp < 0) {
      throw new Error("Forbidden value (" + this.timestamp + ") on element timestamp.");
    }
    param1.writeInt(this.timestamp);
    if (this.memberId < 0 || this.memberId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.memberId + ") on element memberId.");
    }
    param1.writeVarLong(this.memberId);
    param1.writeUTF(this.memberName);

    if (this.lastNotifiedTimestamp < 0) {
      throw new Error(
          "Forbidden value (" + this.lastNotifiedTimestamp + ") on element lastNotifiedTimestamp.");
    }
    param1.writeInt(this.lastNotifiedTimestamp);
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

    this.lastNotifiedTimestamp = param1.readInt();
    if (this.lastNotifiedTimestamp < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lastNotifiedTimestamp
              + ") on element of BulletinMessage.lastNotifiedTimestamp.");
    }
  }
}
