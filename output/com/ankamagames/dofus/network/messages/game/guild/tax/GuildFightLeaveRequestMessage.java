package com.ankamagames.dofus.network.messages.game.guild.tax;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildFightLeaveRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int taxCollectorId = 0;
  public Number characterId = 0;
  public static final int protocolId = 5715;

  public void serialize(ICustomDataOutput param1) {
    if (this.taxCollectorId < 0) {
      throw new Error("Forbidden value (" + this.taxCollectorId + ") on element taxCollectorId.");
    }
    param1.writeInt(this.taxCollectorId);
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.characterId + ") on element characterId.");
    }
    param1.writeVarLong(this.characterId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.taxCollectorId = param1.readInt();

    this.characterId = param1.readVarUhLong();
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.characterId
              + ") on element of StartupActionsObjetAttributionMessage.characterId.");
    }
  }
}
