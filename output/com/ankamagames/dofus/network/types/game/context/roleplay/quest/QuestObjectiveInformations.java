package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class QuestObjectiveInformations extends Object implements INetworkType {

  public int objectiveId = 0;
  public boolean objectiveStatus = false;
  public Vector<String> dialogParams;
  private FuncTree _dialogParamstree;
  public static final int protocolId = 385;

  public void serialize(ICustomDataOutput param1) {
    if (this.objectiveId < 0) {
      throw new Error("Forbidden value (" + this.objectiveId + ") on element objectiveId.");
    }
    param1.writeVarShort(this.objectiveId);
    param1.writeBoolean(this.objectiveStatus);
    param1.writeShort(this.dialogParams.length);
    int _loc2_ = 0;
    while (_loc2_ < this.dialogParams.length) {
      param1.writeUTF(this.dialogParams[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    String _loc4_ = null;
    this.objectiveId = param1.readVarUhShort();
    if (this.objectiveId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.objectiveId
              + ") on element of QuestObjectiveInformations.objectiveId.");
    }

    this.objectiveStatus = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUTF();
      this.dialogParams.push(_loc4_);
      _loc3_++;
    }
  }
}
