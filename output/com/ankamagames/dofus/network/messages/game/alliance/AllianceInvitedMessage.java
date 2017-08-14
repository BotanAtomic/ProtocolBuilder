package com.ankamagames.dofus.network.messages.game.alliance;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceInvitedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number recruterId = 0;
  public String recruterName = "";
  public BasicNamedAllianceInformations allianceInfo;
  private FuncTree _allianceInfotree;
  public static final int protocolId = 6397;

  public void serialize(ICustomDataOutput param1) {
    if (this.recruterId < 0 || this.recruterId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.recruterId + ") on element recruterId.");
    }
    param1.writeVarLong(this.recruterId);
    param1.writeUTF(this.recruterName);
    this.allianceInfo.serializeAs_BasicNamedAllianceInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.recruterId = param1.readVarUhLong();
    if (this.recruterId < 0 || this.recruterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.recruterId
              + ") on element of GuildInvitedMessage.recruterId.");
    }

    this.recruterName = param1.readUTF();

    this.allianceInfo = new BasicNamedAllianceInformations();
    this.allianceInfo.deserialize(param1);
  }
}
