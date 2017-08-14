package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.dofus.network.messages.game.social.SocialNoticeMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceMotdMessage extends SocialNoticeMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 6685;

  @Override
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
  }
}
