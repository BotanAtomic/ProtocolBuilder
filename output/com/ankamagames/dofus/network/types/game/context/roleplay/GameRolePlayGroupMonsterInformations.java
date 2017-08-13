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
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
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


    public int getTypeId() {
         return 160;
    }

    public GameRolePlayGroupMonsterInformations initGameRolePlayGroupMonsterInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,GroupMonsterStaticInformations  param4,Number  param5,int  param6,int  param7,int  param8,boolean  param9,boolean  param10,boolean  param11) {
         super.initGameRolePlayActorInformations(param1,param2,param3);
         this.staticInfos = param4;
         this.creationTime = param5;
         this.ageBonusRate = param6;
         this.lootShare = param7;
         this.alignmentSide = param8;
         this.keyRingBonus = param9;
         this.hasHardcoreDrop = param10;
         this.hasAVARewardToken = param11;
         return this;
    }

    public void reset() {
         super.reset();
         this.staticInfos = new GroupMonsterStaticInformations();
         this.ageBonusRate = 0;
         this.lootShare = 0;
         this.alignmentSide = 0;
         this.keyRingBonus = false;
         this.hasHardcoreDrop = false;
         this.hasAVARewardToken = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayGroupMonsterInformations(param1);
    }

    public void serializeAs_GameRolePlayGroupMonsterInformations(ICustomDataOutput param1) {
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
         this.deserializeAs_GameRolePlayGroupMonsterInformations(param1);
    }

    public void deserializeAs_GameRolePlayGroupMonsterInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.deserializeByteBoxes(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.staticInfos = ProtocolTypeManager.getInstance(GroupMonsterStaticInformations,_loc2_);
         this.staticInfos.deserialize(param1);
         this._creationTimeFunc(param1);
         this._ageBonusRateFunc(param1);
         this._lootShareFunc(param1);
         this._alignmentSideFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayGroupMonsterInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayGroupMonsterInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this.deserializeByteBoxes);
         this._staticInfostree = param1.addChild(this._staticInfostreeFunc);
         param1.addChild(this._creationTimeFunc);
         param1.addChild(this._ageBonusRateFunc);
         param1.addChild(this._lootShareFunc);
         param1.addChild(this._alignmentSideFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.keyRingBonus = BooleanByteWrapper.getFlag(_loc2_,0);
         this.hasHardcoreDrop = BooleanByteWrapper.getFlag(_loc2_,1);
         this.hasAVARewardToken = BooleanByteWrapper.getFlag(_loc2_,2);
    }

    private void _staticInfostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.staticInfos = ProtocolTypeManager.getInstance(GroupMonsterStaticInformations,_loc2_);
         this.staticInfos.deserializeAsync(this._staticInfostree);
    }

    private void _creationTimeFunc(ICustomDataInput param1) {
         this.creationTime = param1.readDouble();
         if(this.creationTime < 0 || this.creationTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.creationTime + ") on element of GameRolePlayGroupMonsterInformations.creationTime.");
         }
    }

    private void _ageBonusRateFunc(ICustomDataInput param1) {
         this.ageBonusRate = param1.readInt();
         if(this.ageBonusRate < 0)
         {
            throw new Exception("Forbidden value (" + this.ageBonusRate + ") on element of GameRolePlayGroupMonsterInformations.ageBonusRate.");
         }
    }

    private void _lootShareFunc(ICustomDataInput param1) {
         this.lootShare = param1.readByte();
         if(this.lootShare < -1 || this.lootShare > 8)
         {
            throw new Exception("Forbidden value (" + this.lootShare + ") on element of GameRolePlayGroupMonsterInformations.lootShare.");
         }
    }

    private void _alignmentSideFunc(ICustomDataInput param1) {
         this.alignmentSide = param1.readByte();
    }

}