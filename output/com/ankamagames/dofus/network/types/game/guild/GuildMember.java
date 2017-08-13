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


    public void serialize(ICustomDataOutput param1) {
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
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of AbstractCharacterInformation.id.");
         }
         this.name = param1.readUTF();
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of CharacterMinimalInformations.level.");
         }
         int _loc2_ = param1.readByte();
         this.sex = BooleanByteWrapper.getFlag(_loc2_,0);
         this.havenBagShared = BooleanByteWrapper.getFlag(_loc2_,1);
         this.breed = param1.readByte();
         this.rank = param1.readVarUhShort();
         if(this.rank < 0)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element of GuildMember.rank.");
         }
         this.givenExperience = param1.readVarUhLong();
         if(this.givenExperience < 0 || this.givenExperience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.givenExperience + ") on element of GuildMember.givenExperience.");
         }
         this.experienceGivenPercent = param1.readByte();
         if(this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100)
         {
            throw new Exception("Forbidden value (" + this.experienceGivenPercent + ") on element of GuildMember.experienceGivenPercent.");
         }
         this.rights = param1.readVarUhInt();
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element of GuildMember.rights.");
         }
         this.connected = param1.readByte();
         if(this.connected < 0)
         {
            throw new Exception("Forbidden value (" + this.connected + ") on element of GuildMember.connected.");
         }
         this.alignmentSide = param1.readByte();
         this.hoursSinceLastConnection = param1.readUnsignedShort();
         if(this.hoursSinceLastConnection < 0 || this.hoursSinceLastConnection > 65535)
         {
            throw new Exception("Forbidden value (" + this.hoursSinceLastConnection + ") on element of GuildMember.hoursSinceLastConnection.");
         }
         this.moodSmileyId = param1.readVarUhShort();
         if(this.moodSmileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.moodSmileyId + ") on element of GuildMember.moodSmileyId.");
         }
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
         }
         this.achievementPoints = param1.readInt();
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
    }

}