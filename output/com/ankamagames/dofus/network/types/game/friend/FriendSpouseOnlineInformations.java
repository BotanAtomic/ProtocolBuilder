package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FriendSpouseOnlineInformations extends FriendSpouseInformations implements INetworkType {

    private int protocolId = 93;
    private int mapId = 0;
    private int subAreaId = 0;
    private boolean inFight = false;
    private boolean followSpouse = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.spouseAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.spouseAccountId + ") on element spouseAccountId.");
         }
         param1.writeInt(this.spouseAccountId);
         if(this.spouseId < 0 || this.spouseId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.spouseId + ") on element spouseId.");
         }
         param1.writeVarLong(this.spouseId);
         param1.writeUTF(this.spouseName);
         if(this.spouseLevel < 1 || this.spouseLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.spouseLevel + ") on element spouseLevel.");
         }
         param1.writeByte(this.spouseLevel);
         param1.writeByte(this.breed);
         param1.writeByte(this.sex);
         this.spouseEntityLook.serializeAs_EntityLook(param1);
         this.guildInfo.serializeAs_GuildInformations(param1);
         param1.writeByte(this.alignmentSide);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.inFight);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.followSpouse);
         param1.writeByte(_loc2_);
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
         }
         param1.writeInt(this.mapId);
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.spouseAccountId = param1.readInt();
         if(this.spouseAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.spouseAccountId + ") on element of FriendSpouseInformations.spouseAccountId.");
         }
         this.spouseId = param1.readVarUhLong();
         if(this.spouseId < 0 || this.spouseId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.spouseId + ") on element of FriendSpouseInformations.spouseId.");
         }
         this.spouseName = param1.readUTF();
         this.spouseLevel = param1.readUnsignedByte();
         if(this.spouseLevel < 1 || this.spouseLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.spouseLevel + ") on element of FriendSpouseInformations.spouseLevel.");
         }
         this.breed = param1.readByte();
         this.sex = param1.readByte();
         this.spouseEntityLook = new EntityLook();
         this.spouseEntityLook.deserialize(param1);
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
         this.alignmentSide = param1.readByte();
         int _loc2_ = param1.readByte();
         this.inFight = BooleanByteWrapper.getFlag(_loc2_,0);
         this.followSpouse = BooleanByteWrapper.getFlag(_loc2_,1);
         this.mapId = param1.readInt();
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element of FriendSpouseOnlineInformations.mapId.");
         }
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of FriendSpouseOnlineInformations.subAreaId.");
         }
    }

}