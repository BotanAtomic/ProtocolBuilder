package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightMinimalStats;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class RefreshCharacterStatsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number fighterId = 0;
  public GameFightMinimalStats stats;
  private FuncTree _statstree;
  public static final int protocolId = 6699;

  public void serialize(ICustomDataOutput param1) {
    if (this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.fighterId + ") on element fighterId.");
    }
    param1.writeDouble(this.fighterId);
    this.stats.serializeAs_GameFightMinimalStats(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fighterId = param1.readDouble();
    if (this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.fighterId
              + ") on element of RefreshCharacterStatsMessage.fighterId.");
    }

    this.stats = new GameFightMinimalStats();
    this.stats.deserialize(param1);
  }
}
