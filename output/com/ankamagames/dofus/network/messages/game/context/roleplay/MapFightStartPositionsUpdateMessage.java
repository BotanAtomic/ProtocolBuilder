package com.ankamagames.dofus.network.messages.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightStartingPositions;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapFightStartPositionsUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int mapId = 0;
  public FightStartingPositions fightStartPositions;
  private FuncTree _fightStartPositionstree;
  public static final int protocolId = 6716;

  public void serialize(ICustomDataOutput param1) {
    if (this.mapId < 0) {
      throw new Error("Forbidden value (" + this.mapId + ") on element mapId.");
    }
    param1.writeInt(this.mapId);
    this.fightStartPositions.serializeAs_FightStartingPositions(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.mapId = param1.readInt();

    this.fightStartPositions = new FightStartingPositions();
    this.fightStartPositions.deserialize(param1);
  }
}
