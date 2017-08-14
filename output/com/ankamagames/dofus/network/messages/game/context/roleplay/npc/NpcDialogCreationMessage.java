package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NpcDialogCreationMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int mapId = 0;
  public int npcId = 0;
  public static final int protocolId = 5618;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.mapId);
    param1.writeInt(this.npcId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.mapId = param1.readInt();

    this.npcId = param1.readVarUhShort();
    if (this.npcId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.npcId
              + ") on element of TreasureHuntStepFollowDirectionToHint.npcId.");
    }
  }
}
