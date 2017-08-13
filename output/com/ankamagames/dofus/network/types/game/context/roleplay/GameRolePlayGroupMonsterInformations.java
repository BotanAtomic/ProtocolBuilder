package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayGroupMonsterInformations extends GameRolePlayActorInformations implements INetworkType {

    private int protocolId = 160;
    private GroupMonsterStaticInformations staticInfos;
    private Number creationTime = 0;
    private int ageBonusRate = 0;
    private int lootShare = 0;
    private int alignmentSide = 0;
    private boolean keyRingBonus = false;
    private boolean hasHardcoreDrop = false;
    private boolean hasAVARewardToken = false;
    private FuncTree _staticInfostree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.keyRingBonus);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.hasHardcoreDrop);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.hasAVARewardToken);
         param1.writeByte(_loc2_);
         param1.writeShort(this.staticInfos.getTypeId());
         this.staticInfos.serialize(param1);
         if(this.creationTime < 0 || this.creationTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.creationTime + ") on element creationTime.");
         }
         param1.writeDouble(this.creationTime);
         if(this.ageBonusRate < 0)
         {
            throw new Exception("Forbidden value (" + this.ageBonusRate + ") on element ageBonusRate.");
         }
         param1.writeInt(this.ageBonusRate);
         if(this.lootShare < -1 || this.lootShare > 8)
         {
            throw new Exception("Forbidden value (" + this.lootShare + ") on element lootShare.");
         }
         param1.writeByte(this.lootShare);
         param1.writeByte(this.alignmentSide);
    }

    public void deserialize(ICustomDataInput param1) {
         this.contextualId = param1.readDouble();
         if(this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.contextualId + ") on element of GameContextActorInformations.contextualId.");
         }
         this.look = new EntityLook();
         this.look.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.disposition = ProtocolTypeManager.getInstance(EntityDispositionInformations,_loc2_);
         this.disposition.deserialize(param1);
         int _loc2_ = param1.readByte();
         this.keyRingBonus = BooleanByteWrapper.getFlag(_loc2_,0);
         this.hasHardcoreDrop = BooleanByteWrapper.getFlag(_loc2_,1);
         this.hasAVARewardToken = BooleanByteWrapper.getFlag(_loc2_,2);
         int _loc2_ = param1.readUnsignedShort();
         this.staticInfos = ProtocolTypeManager.getInstance(GroupMonsterStaticInformations,_loc2_);
         this.staticInfos.deserialize(param1);
         this.creationTime = param1.readDouble();
         if(this.creationTime < 0 || this.creationTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.creationTime + ") on element of GameRolePlayGroupMonsterInformations.creationTime.");
         }
         this.ageBonusRate = param1.readInt();
         if(this.ageBonusRate < 0)
         {
            throw new Exception("Forbidden value (" + this.ageBonusRate + ") on element of GameRolePlayGroupMonsterInformations.ageBonusRate.");
         }
         this.lootShare = param1.readByte();
         if(this.lootShare < -1 || this.lootShare > 8)
         {
            throw new Exception("Forbidden value (" + this.lootShare + ") on element of GameRolePlayGroupMonsterInformations.lootShare.");
         }
         this.alignmentSide = param1.readByte();
    }

}