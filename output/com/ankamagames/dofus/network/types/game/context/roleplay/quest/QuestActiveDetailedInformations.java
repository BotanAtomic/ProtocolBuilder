package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class QuestActiveDetailedInformations extends QuestActiveInformations
    implements INetworkType {

  public int stepId = 0;
  public Vector<QuestObjectiveInformations> objectives;
  private FuncTree _objectivestree;
  public static final int protocolId = 382;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.questId < 0) {
      throw new Error("Forbidden value (" + this.questId + ") on element questId.");
    }
    param1.writeVarShort(this.questId);

    if (this.stepId < 0) {
      throw new Error("Forbidden value (" + this.stepId + ") on element stepId.");
    }
    param1.writeVarShort(this.stepId);
    param1.writeShort(this.objectives.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objectives.length) {
      param1.writeShort(((QuestObjectiveInformations) (this.objectives[_loc2_])).getTypeId());
      ((QuestObjectiveInformations) this.objectives[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    QuestObjectiveInformations _loc5_ = null;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.stepId = param1.readVarUhShort();
    if (this.stepId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.stepId
              + ") on element of QuestActiveDetailedInformations.stepId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(QuestObjectiveInformations, _loc4_);
      _loc5_.deserialize(param1);
      this.objectives.push(_loc5_);
      _loc3_++;
    }
  }
}
