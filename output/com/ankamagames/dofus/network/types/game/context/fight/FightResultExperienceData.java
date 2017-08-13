package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FightResultExperienceData extends FightResultAdditionalData implements INetworkType {

    private int protocolId = 192;
    private Number experience = 0;
    private boolean showExperience = false;
    private Number experienceLevelFloor = 0;
    private boolean showExperienceLevelFloor = false;
    private Number experienceNextLevelFloor = 0;
    private boolean showExperienceNextLevelFloor = false;
    private Number experienceFightDelta = 0;
    private boolean showExperienceFightDelta = false;
    private Number experienceForGuild = 0;
    private boolean showExperienceForGuild = false;
    private Number experienceForMount = 0;
    private boolean showExperienceForMount = false;
    private boolean isIncarnationExperience = false;
    private int rerollExperienceMul = 0;
    private int _loc2_ = 0;


    public int getTypeId() {
         return 192;
    }

    public FightResultExperienceData initFightResultExperienceData(Number param1,boolean  param2,Number  param3,boolean  param4,Number  param5,boolean  param6,Number  param7,boolean  param8,Number  param9,boolean  param10,Number  param11,boolean  param12,boolean  param13,int  param14) {
         this.experience = param1;
         this.showExperience = param2;
         this.experienceLevelFloor = param3;
         this.showExperienceLevelFloor = param4;
         this.experienceNextLevelFloor = param5;
         this.showExperienceNextLevelFloor = param6;
         this.experienceFightDelta = param7;
         this.showExperienceFightDelta = param8;
         this.experienceForGuild = param9;
         this.showExperienceForGuild = param10;
         this.experienceForMount = param11;
         this.showExperienceForMount = param12;
         this.isIncarnationExperience = param13;
         this.rerollExperienceMul = param14;
         return this;
    }

    public void reset() {
         this.experience = 0;
         this.showExperience = false;
         this.experienceLevelFloor = 0;
         this.showExperienceLevelFloor = false;
         this.experienceNextLevelFloor = 0;
         this.showExperienceNextLevelFloor = false;
         this.experienceFightDelta = 0;
         this.showExperienceFightDelta = false;
         this.experienceForGuild = 0;
         this.showExperienceForGuild = false;
         this.experienceForMount = 0;
         this.showExperienceForMount = false;
         this.isIncarnationExperience = false;
         this.rerollExperienceMul = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightResultExperienceData(param1);
    }

    public void serializeAs_FightResultExperienceData(ICustomDataOutput param1) {
         super.serializeAs_FightResultAdditionalData(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.showExperience);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.showExperienceLevelFloor);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.showExperienceNextLevelFloor);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.showExperienceFightDelta);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,4,this.showExperienceForGuild);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,5,this.showExperienceForMount);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,6,this.isIncarnationExperience);
         param1.writeByte(_loc2_);
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultExperienceData(param1);
    }

    public void deserializeAs_FightResultExperienceData(ICustomDataInput param1) {
         super.deserialize(param1);
         this.deserializeByteBoxes(param1);
         this._experienceFunc(param1);
         this._experienceLevelFloorFunc(param1);
         this._experienceNextLevelFloorFunc(param1);
         this._experienceFightDeltaFunc(param1);
         this._experienceForGuildFunc(param1);
         this._experienceForMountFunc(param1);
         this._rerollExperienceMulFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightResultExperienceData(param1);
    }

    public void deserializeAsyncAs_FightResultExperienceData(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._experienceFunc);
         param1.addChild(this._experienceLevelFloorFunc);
         param1.addChild(this._experienceNextLevelFloorFunc);
         param1.addChild(this._experienceFightDeltaFunc);
         param1.addChild(this._experienceForGuildFunc);
         param1.addChild(this._experienceForMountFunc);
         param1.addChild(this._rerollExperienceMulFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.showExperience = BooleanByteWrapper.getFlag(_loc2_,0);
         this.showExperienceLevelFloor = BooleanByteWrapper.getFlag(_loc2_,1);
         this.showExperienceNextLevelFloor = BooleanByteWrapper.getFlag(_loc2_,2);
         this.showExperienceFightDelta = BooleanByteWrapper.getFlag(_loc2_,3);
         this.showExperienceForGuild = BooleanByteWrapper.getFlag(_loc2_,4);
         this.showExperienceForMount = BooleanByteWrapper.getFlag(_loc2_,5);
         this.isIncarnationExperience = BooleanByteWrapper.getFlag(_loc2_,6);
    }

    private void _experienceFunc(ICustomDataInput param1) {
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experience + ") on element of FightResultExperienceData.experience.");
    }

    private void _experienceLevelFloorFunc(ICustomDataInput param1) {
         this.experienceLevelFloor = param1.readVarUhLong();
         if(this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceLevelFloor + ") on element of FightResultExperienceData.experienceLevelFloor.");
    }

    private void _experienceNextLevelFloorFunc(ICustomDataInput param1) {
         this.experienceNextLevelFloor = param1.readVarUhLong();
         if(this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceNextLevelFloor + ") on element of FightResultExperienceData.experienceNextLevelFloor.");
    }

    private void _experienceFightDeltaFunc(ICustomDataInput param1) {
         this.experienceFightDelta = param1.readVarUhLong();
         if(this.experienceFightDelta < 0 || this.experienceFightDelta > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceFightDelta + ") on element of FightResultExperienceData.experienceFightDelta.");
    }

    private void _experienceForGuildFunc(ICustomDataInput param1) {
         this.experienceForGuild = param1.readVarUhLong();
         if(this.experienceForGuild < 0 || this.experienceForGuild > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceForGuild + ") on element of FightResultExperienceData.experienceForGuild.");
    }

    private void _experienceForMountFunc(ICustomDataInput param1) {
         this.experienceForMount = param1.readVarUhLong();
         if(this.experienceForMount < 0 || this.experienceForMount > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceForMount + ") on element of FightResultExperienceData.experienceForMount.");
    }

    private void _rerollExperienceMulFunc(ICustomDataInput param1) {
         this.rerollExperienceMul = param1.readByte();
         if(this.rerollExperienceMul < 0)
            throw new Exception("Forbidden value (" + this.rerollExperienceMul + ") on element of FightResultExperienceData.rerollExperienceMul.");
    }

}