package com.ankamagames.dofus.network.messages.game.social;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SocialNoticeMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String content = "";
  public int timestamp = 0;
  public Number memberId = 0;
  public String memberName = "";
  public static final int protocolId = 6688;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.content);
    if (this.timestamp < 0) {
      throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
    }
    param1.writeInt(this.timestamp);
    if (this.memberId < 0 || this.memberId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
    }
    param1.writeVarLong(this.memberId);
    param1.writeUTF(this.memberName);
  }

  public void deserialize(ICustomDataInput param1) {
    this.content = param1.readUTF();

    this.timestamp = param1.readDouble();
    if (this.timestamp < -9.007199254740992E15 || this.timestamp > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.timestamp
              + ") on element of SubscriptionUpdateMessage.timestamp.");
    }

    this.memberId = param1.readInt();
    if (this.memberId < 0) {
      throw new Exception(
          "Forbidden value (" + this.memberId + ") on element of PartyMemberGeoPosition.memberId.");
    }

    this.memberName = param1.readUTF();
  }
}
