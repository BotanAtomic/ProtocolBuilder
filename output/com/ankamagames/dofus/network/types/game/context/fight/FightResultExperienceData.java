package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
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


    public void serialize(ICustomDataOutput param1) {
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
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
         }
         param1.writeVarLong(this.experience);
         if(this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceLevelFloor + ") on element experienceLevelFloor.");
         }
         param1.writeVarLong(this.experienceLevelFloor);
         if(this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceNextLevelFloor + ") on element experienceNextLevelFloor.");
         }
         param1.writeVarLong(this.experienceNextLevelFloor);
         if(this.experienceFightDelta < 0 || this.experienceFightDelta > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceFightDelta + ") on element experienceFightDelta.");
         }
         param1.writeVarLong(this.experienceFightDelta);
         if(this.experienceForGuild < 0 || this.experienceForGuild > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceForGuild + ") on element experienceForGuild.");
         }
         param1.writeVarLong(this.experienceForGuild);
         if(this.experienceForMount < 0 || this.experienceForMount > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceForMount + ") on element experienceForMount.");
         }
         param1.writeVarLong(this.experienceForMount);
         if(this.rerollExperienceMul < 0)
         {
            throw new Exception("Forbidden value (" + this.rerollExperienceMul + ") on element rerollExperienceMul.");
         }
         param1.writeByte(this.rerollExperienceMul);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.showExperience = BooleanByteWrapper.getFlag(_loc2_,0);
         this.showExperienceLevelFloor = BooleanByteWrapper.getFlag(_loc2_,1);
         this.showExperienceNextLevelFloor = BooleanByteWrapper.getFlag(_loc2_,2);
         this.showExperienceFightDelta = BooleanByteWrapper.getFlag(_loc2_,3);
         this.showExperienceForGuild = BooleanByteWrapper.getFlag(_loc2_,4);
         this.showExperienceForMount = BooleanByteWrapper.getFlag(_loc2_,5);
         this.isIncarnationExperience = BooleanByteWrapper.getFlag(_loc2_,6);
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element of FightResultExperienceData.experience.");
         }
         this.experienceLevelFloor = param1.readVarUhLong();
         if(this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceLevelFloor + ") on element of FightResultExperienceData.experienceLevelFloor.");
         }
         this.experienceNextLevelFloor = param1.readVarUhLong();
         if(this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceNextLevelFloor + ") on element of FightResultExperienceData.experienceNextLevelFloor.");
         }
         this.experienceFightDelta = param1.readVarUhLong();
         if(this.experienceFightDelta < 0 || this.experienceFightDelta > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceFightDelta + ") on element of FightResultExperienceData.experienceFightDelta.");
         }
         this.experienceForGuild = param1.readVarUhLong();
         if(this.experienceForGuild < 0 || this.experienceForGuild > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceForGuild + ") on element of FightResultExperienceData.experienceForGuild.");
         }
         this.experienceForMount = param1.readVarUhLong();
         if(this.experienceForMount < 0 || this.experienceForMount > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceForMount + ") on element of FightResultExperienceData.experienceForMount.");
         }
         this.rerollExperienceMul = param1.readByte();
         if(this.rerollExperienceMul < 0)
         {
            throw new Exception("Forbidden value (" + this.rerollExperienceMul + ") on element of FightResultExperienceData.rerollExperienceMul.");
         }
    }

}