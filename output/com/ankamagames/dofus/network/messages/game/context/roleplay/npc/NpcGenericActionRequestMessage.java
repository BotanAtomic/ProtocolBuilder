package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NpcGenericActionRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int npcId = 0;
  public int npcActionId = 0;
  public int npcMapId = 0;
  public static final int protocolId = 5898;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.npcId);
    if (this.npcActionId < 0) {
      throw new Error("Forbidden value (" + this.npcActionId + ") on element npcActionId.");
    }
    param1.writeByte(this.npcActionId);
    param1.writeInt(this.npcMapId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.npcId = param1.readVarUhShort();
    if (this.npcId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.npcId
              + ") on element of TreasureHuntStepFollowDirectionToHint.npcId.");
    }

    this.npcActionId = param1.readByte();
    if (this.npcActionId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.npcActionId
              + ") on element of NpcGenericActionRequestMessage.npcActionId.");
    }

    this.npcMapId = param1.readInt();
  }
}
