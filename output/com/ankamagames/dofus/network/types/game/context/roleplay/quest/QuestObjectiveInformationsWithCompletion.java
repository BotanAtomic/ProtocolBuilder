package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class QuestObjectiveInformationsWithCompletion extends QuestObjectiveInformations
    implements INetworkType {

  public int curCompletion = 0;
  public int maxCompletion = 0;
  public static final int protocolId = 386;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.objectiveId < 0) {
      throw new Exception("Forbidden value (" + this.objectiveId + ") on element objectiveId.");
    }
    param1.writeVarShort(this.objectiveId);
    param1.writeBoolean(this.objectiveStatus);
    param1.writeShort(this.dialogParams.length);
    int _loc2_ = 0;
    while (_loc2_ < this.dialogParams.length) {
      param1.writeUTF(this.dialogParams[_loc2_]);
      _loc2_++;
    }

    if (this.curCompletion < 0) {
      throw new Exception("Forbidden value (" + this.curCompletion + ") on element curCompletion.");
    }
    param1.writeVarShort(this.curCompletion);
    if (this.maxCompletion < 0) {
      throw new Exception("Forbidden value (" + this.maxCompletion + ") on element maxCompletion.");
    }
    param1.writeVarShort(this.maxCompletion);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.curCompletion = param1.readVarUhShort();
    if (this.curCompletion < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.curCompletion
              + ") on element of QuestObjectiveInformationsWithCompletion.curCompletion.");
    }

    this.maxCompletion = param1.readVarUhShort();
    if (this.maxCompletion < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.maxCompletion
              + ") on element of QuestObjectiveInformationsWithCompletion.maxCompletion.");
    }
  }
}
