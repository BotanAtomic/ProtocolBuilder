package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class QuestActiveDetailedInformations extends QuestActiveInformations implements INetworkType {

    private int protocolId = 382;
    private int stepId = 0;
    private Vector<QuestObjectiveInformations> objectives;
    private FuncTree _objectivestree;


    public int getTypeId() {
         return 382;
    }

    public QuestActiveDetailedInformations initQuestActiveDetailedInformations(int param1,int  param2,Vector<QuestObjectiveInformations>  param3) {
         super.initQuestActiveInformations(param1);
         this.stepId = param2;
         this.objectives = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.stepId = 0;
         this.objectives = new Vector.<QuestObjectiveInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_QuestActiveDetailedInformations(param1);
    }

    public void serializeAs_QuestActiveDetailedInformations(ICustomDataOutput param1) {
         super.serializeAs_QuestActiveInformations(param1);
         if(this.stepId < 0)
         {
            throw new Exception("Forbidden value (" + this.stepId + ") on element stepId.");
         }
         param1.writeVarShort(this.stepId);
         param1.writeShort(this.objectives.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectives.length)
         {
            param1.writeShort((this.objectives[_loc2_] as QuestObjectiveInformations).getTypeId());
            (this.objectives[_loc2_] as QuestObjectiveInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_QuestActiveDetailedInformations(param1);
    }

    public void deserializeAs_QuestActiveDetailedInformations(ICustomDataInput param1) {
         int _loc4_ = 0;
         QuestObjectiveInformations _loc5_ = null;
         super.deserialize(param1);
         this._stepIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(QuestObjectiveInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.objectives.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QuestActiveDetailedInformations(param1);
    }

    public void deserializeAsyncAs_QuestActiveDetailedInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._stepIdFunc);
         this._objectivestree = param1.addChild(this._objectivestreeFunc);
    }

    private void _stepIdFunc(ICustomDataInput param1) {
         this.stepId = param1.readVarUhShort();
         if(this.stepId < 0)
         {
            throw new Exception("Forbidden value (" + this.stepId + ") on element of QuestActiveDetailedInformations.stepId.");
         }
    }

    private void _objectivestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._objectivestree.addChild(this._objectivesFunc);
            _loc3_++;
         }
    }

    private void _objectivesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         QuestObjectiveInformations _loc3_ = ProtocolTypeManager.getInstance(QuestObjectiveInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.objectives.push(_loc3_);
    }

}