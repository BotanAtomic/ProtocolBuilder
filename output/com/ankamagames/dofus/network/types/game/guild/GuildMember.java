package com.ankamagames.dofus.network.types.game.guild;

import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GuildMember extends CharacterMinimalInformations implements INetworkType {

    private int protocolId = 88;
    private int breed = 0;
    private boolean sex = false;
    private int rank = 0;
    private Number givenExperience = 0;
    private int experienceGivenPercent = 0;
    private int rights = 0;
    private int connected = 99;
    private int alignmentSide = 0;
    private int hoursSinceLastConnection = 0;
    private int moodSmileyId = 0;
    private int accountId = 0;
    private int achievementPoints = 0;
    private PlayerStatus status;
    private boolean havenBagShared = false;
    private FuncTree _statustree;


    public int getTypeId() {
         return 88;
    }

    public GuildMember initGuildMember(Number param1,String  param2,int  param3,int  param4,boolean  param5,int  param6,Number  param7,int  param8,int  param9,int  param10,int  param11,int  param12,int  param13,int  param14,int  param15,PlayerStatus  param16,boolean  param17) {
         super.initCharacterMinimalInformations(param1,param2,param3);
         this.breed = param4;
         this.sex = param5;
         this.rank = param6;
         this.givenExperience = param7;
         this.experienceGivenPercent = param8;
         this.rights = param9;
         this.connected = param10;
         this.alignmentSide = param11;
         this.hoursSinceLastConnection = param12;
         this.moodSmileyId = param13;
         this.accountId = param14;
         this.achievementPoints = param15;
         this.status = param16;
         this.havenBagShared = param17;
         return this;
    }

    public void reset() {
         super.reset();
         this.breed = 0;
         this.sex = false;
         this.rank = 0;
         this.givenExperience = 0;
         this.experienceGivenPercent = 0;
         this.rights = 0;
         this.connected = 99;
         this.alignmentSide = 0;
         this.hoursSinceLastConnection = 0;
         this.moodSmileyId = 0;
         this.accountId = 0;
         this.achievementPoints = 0;
         this.status = new PlayerStatus();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildMember(param1);
    }

    public void serializeAs_GuildMember(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalInformations(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.sex);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.havenBagShared);
         param1.writeByte(_loc2_);
         param1.writeByte(this.breed);
         if(this.rank < 0)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element rank.");
         }
         param1.writeVarShort(this.rank);
         if(this.givenExperience < 0 || this.givenExperience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.givenExperience + ") on element givenExperience.");
         }
         param1.writeVarLong(this.givenExperience);
         if(this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100)
         {
            throw new Exception("Forbidden value (" + this.experienceGivenPercent + ") on element experienceGivenPercent.");
         }
         param1.writeByte(this.experienceGivenPercent);
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element rights.");
         }
         param1.writeVarInt(this.rights);
         param1.writeByte(this.connected);
         param1.writeByte(this.alignmentSide);
         if(this.hoursSinceLastConnection < 0 || this.hoursSinceLastConnection > 65535)
         {
            throw new Exception("Forbidden value (" + this.hoursSinceLastConnection + ") on element hoursSinceLastConnection.");
         }
         param1.writeShort(this.hoursSinceLastConnection);
         if(this.moodSmileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.moodSmileyId + ") on element moodSmileyId.");
         }
         param1.writeVarShort(this.moodSmileyId);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
         param1.writeInt(this.achievementPoints);
         param1.writeShort(this.status.getTypeId());
         this.status.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildMember(param1);
    }

    public void deserializeAs_GuildMember(ICustomDataInput param1) {
         super.deserialize(param1);
         this.deserializeByteBoxes(param1);
         this._breedFunc(param1);
         this._rankFunc(param1);
         this._givenExperienceFunc(param1);
         this._experienceGivenPercentFunc(param1);
         this._rightsFunc(param1);
         this._connectedFunc(param1);
         this._alignmentSideFunc(param1);
         this._hoursSinceLastConnectionFunc(param1);
         this._moodSmileyIdFunc(param1);
         this._accountIdFunc(param1);
         this._achievementPointsFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildMember(param1);
    }

    public void deserializeAsyncAs_GuildMember(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._breedFunc);
         param1.addChild(this._rankFunc);
         param1.addChild(this._givenExperienceFunc);
         param1.addChild(this._experienceGivenPercentFunc);
         param1.addChild(this._rightsFunc);
         param1.addChild(this._connectedFunc);
         param1.addChild(this._alignmentSideFunc);
         param1.addChild(this._hoursSinceLastConnectionFunc);
         param1.addChild(this._moodSmileyIdFunc);
         param1.addChild(this._accountIdFunc);
         param1.addChild(this._achievementPointsFunc);
         this._statustree = param1.addChild(this._statustreeFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.sex = BooleanByteWrapper.getFlag(_loc2_,0);
         this.havenBagShared = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
    }

    private void _rankFunc(ICustomDataInput param1) {
         this.rank = param1.readVarUhShort();
         if(this.rank < 0)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element of GuildMember.rank.");
         }
    }

    private void _givenExperienceFunc(ICustomDataInput param1) {
         this.givenExperience = param1.readVarUhLong();
         if(this.givenExperience < 0 || this.givenExperience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.givenExperience + ") on element of GuildMember.givenExperience.");
         }
    }

    private void _experienceGivenPercentFunc(ICustomDataInput param1) {
         this.experienceGivenPercent = param1.readByte();
         if(this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100)
         {
            throw new Exception("Forbidden value (" + this.experienceGivenPercent + ") on element of GuildMember.experienceGivenPercent.");
         }
    }

    private void _rightsFunc(ICustomDataInput param1) {
         this.rights = param1.readVarUhInt();
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element of GuildMember.rights.");
         }
    }

    private void _connectedFunc(ICustomDataInput param1) {
         this.connected = param1.readByte();
         if(this.connected < 0)
         {
            throw new Exception("Forbidden value (" + this.connected + ") on element of GuildMember.connected.");
         }
    }

    private void _alignmentSideFunc(ICustomDataInput param1) {
         this.alignmentSide = param1.readByte();
    }

    private void _hoursSinceLastConnectionFunc(ICustomDataInput param1) {
         this.hoursSinceLastConnection = param1.readUnsignedShort();
         if(this.hoursSinceLastConnection < 0 || this.hoursSinceLastConnection > 65535)
         {
            throw new Exception("Forbidden value (" + this.hoursSinceLastConnection + ") on element of GuildMember.hoursSinceLastConnection.");
         }
    }

    private void _moodSmileyIdFunc(ICustomDataInput param1) {
         this.moodSmileyId = param1.readVarUhShort();
         if(this.moodSmileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.moodSmileyId + ") on element of GuildMember.moodSmileyId.");
         }
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
         }
    }

    private void _achievementPointsFunc(ICustomDataInput param1) {
         this.achievementPoints = param1.readInt();
    }

    private void _statustreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserializeAsync(this._statustree);
    }

}