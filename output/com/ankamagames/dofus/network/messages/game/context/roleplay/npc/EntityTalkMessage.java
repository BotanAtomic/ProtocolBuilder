package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class EntityTalkMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number entityId = 0;
  public int textId = 0;
  public Vector<String> parameters;
  private FuncTree _parameterstree;
  public static final int protocolId = 6110;

  public void serialize(ICustomDataOutput param1) {
    if (this.entityId < -9.007199254740992E15 || this.entityId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.entityId + ") on element entityId.");
    }
    param1.writeDouble(this.entityId);
    if (this.textId < 0) {
      throw new Error("Forbidden value (" + this.textId + ") on element textId.");
    }
    param1.writeVarShort(this.textId);
    param1.writeShort(this.parameters.length);
    int _loc2_ = 0;
    while (_loc2_ < this.parameters.length) {
      param1.writeUTF(this.parameters[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    String _loc4_ = null;
    this.entityId = param1.readVarUhLong();
    if (this.entityId < 0 || this.entityId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.entityId + ") on element of InteractiveUsedMessage.entityId.");
    }

    this.textId = param1.readVarUhShort();
    if (this.textId < 0) {
      throw new Error(
          "Forbidden value (" + this.textId + ") on element of EntityTalkMessage.textId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUTF();
      this.parameters.push(_loc4_);
      _loc3_++;
    }
  }
}
