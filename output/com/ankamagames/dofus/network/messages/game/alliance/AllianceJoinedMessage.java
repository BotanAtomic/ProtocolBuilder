package com.ankamagames.dofus.network.messages.game.alliance;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceJoinedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public AllianceInformations allianceInfo;
  public boolean enabled = false;
  public int leadingGuildId = 0;
  private FuncTree _allianceInfotree;
  public static final int protocolId = 6402;

  public void serialize(ICustomDataOutput param1) {
    this.allianceInfo.serializeAs_AllianceInformations(param1);
    param1.writeBoolean(this.enabled);
    if (this.leadingGuildId < 0) {
      throw new Exception(
          "Forbidden value (" + this.leadingGuildId + ") on element leadingGuildId.");
    }
    param1.writeVarInt(this.leadingGuildId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.allianceInfo = new AllianceInformations();
    this.allianceInfo.deserialize(param1);
    this.enabled = param1.readBoolean();

    this.leadingGuildId = param1.readVarUhInt();
    if (this.leadingGuildId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.leadingGuildId
              + ") on element of AllianceJoinedMessage.leadingGuildId.");
    }
  }
}
