package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayGroupMonsterWaveInformations extends GameRolePlayGroupMonsterInformations implements INetworkType {

    private int protocolId = 464;
    private int nbWaves = 0;
    private GroupMonsterStaticInformations[] alternatives;
    private FuncTree _alternativestree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayGroupMonsterInformations(param1);
         if(this.nbWaves < 0)
         {
            throw new Exception("Forbidden value (" + this.nbWaves + ") on element nbWaves.");
         }
         param1.writeByte(this.nbWaves);
         param1.writeShort(this.alternatives.length);
         int _loc2_ = 0;
         while(_loc2_ < this.alternatives.length)
         {
            param1.writeShort((this.alternatives[_loc2_] as GroupMonsterStaticInformations).getTypeId());
            (this.alternatives[_loc2_] as GroupMonsterStaticInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         GroupMonsterStaticInformations _loc5_ = null;
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
         this.nbWaves = param1.readByte();
         if(this.nbWaves < 0)
         {
            throw new Exception("Forbidden value (" + this.nbWaves + ") on element of GameRolePlayGroupMonsterWaveInformations.nbWaves.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(GroupMonsterStaticInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.alternatives.push(_loc5_);
            _loc3_++;
         }
    }

}