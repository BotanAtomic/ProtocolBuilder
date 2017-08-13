package package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionMemberInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
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

public class PartyMemberInformations extends CharacterBaseInformations implements INetworkType {

    private int protocolId = 90;
    private int lifePoints = 0;
    private int maxLifePoints = 0;
    private int prospecting = 0;
    private int regenRate = 0;
    private int initiative = 0;
    private int alignmentSide = 0;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;
    private PlayerStatus status = ;
    private Vector.<PartyCompanionMemberInformations> companions = ;
    private FuncTree _statustree = ;
    private FuncTree _companionstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = param1.readUnsignedShort();
    private int _loc4_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 90;
    }

    public PartyMemberInformations initPartyMemberInformations(Number param1,String  param2,int  param3,EntityLook  param4,int  param5,boolean  param6,int  param7,int  param8,int  param9,int  param10,int  param11,int  param12,int  param13,int  param14,int  param15,int  param16,PlayerStatus  param17,Vector.<PartyCompanionMemberInformations>  param18) {
         super.initCharacterBaseInformations(param1,param2,param3,param4,param5,param6);
         this.lifePoints = param7;
         this.maxLifePoints = param8;
         this.prospecting = param9;
         this.regenRate = param10;
         this.initiative = param11;
         this.alignmentSide = param12;
         this.worldX = param13;
         this.worldY = param14;
         this.mapId = param15;
         this.subAreaId = param16;
         this.status = param17;
         this.companions = param18;
         return this;
    }

    public void reset() {
         super.reset();
         this.lifePoints = 0;
         this.maxLifePoints = 0;
         this.prospecting = 0;
         this.regenRate = 0;
         this.initiative = 0;
         this.alignmentSide = 0;
         this.worldX = 0;
         this.worldY = 0;
         this.mapId = 0;
         this.subAreaId = 0;
         this.status = new PlayerStatus();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyMemberInformations(param1);
    }

    public void serializeAs_PartyMemberInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterBaseInformations(param1);
         if(this.lifePoints < 0)
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyMemberInformations(param1);
    }

    public void deserializeAs_PartyMemberInformations(ICustomDataInput param1) {
         PartyCompanionMemberInformations _loc5_ = null;
         super.deserialize(param1);
         this._lifePointsFunc(param1);
         this._maxLifePointsFunc(param1);
         this._prospectingFunc(param1);
         this._regenRateFunc(param1);
         this._initiativeFunc(param1);
         this._alignmentSideFunc(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
            _loc5_ = new PartyCompanionMemberInformations();
            _loc5_.deserialize(param1);
            this.companions.push(_loc5_);
            _loc4_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyMemberInformations(param1);
    }

    public void deserializeAsyncAs_PartyMemberInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._lifePointsFunc);
         param1.addChild(this._maxLifePointsFunc);
         param1.addChild(this._prospectingFunc);
         param1.addChild(this._regenRateFunc);
         param1.addChild(this._initiativeFunc);
         param1.addChild(this._alignmentSideFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._subAreaIdFunc);
         this._statustree = param1.addChild(this._statustreeFunc);
         this._companionstree = param1.addChild(this._companionstreeFunc);
    }

    private void _lifePointsFunc(ICustomDataInput param1) {
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of PartyMemberInformations.lifePoints.");
    }

    private void _maxLifePointsFunc(ICustomDataInput param1) {
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of PartyMemberInformations.maxLifePoints.");
    }

    private void _prospectingFunc(ICustomDataInput param1) {
         this.prospecting = param1.readVarUhShort();
         if(this.prospecting < 0)
            throw new Exception("Forbidden value (" + this.prospecting + ") on element of PartyMemberInformations.prospecting.");
    }

    private void _regenRateFunc(ICustomDataInput param1) {
         this.regenRate = param1.readUnsignedByte();
         if(this.regenRate < 0 || this.regenRate > 255)
            throw new Exception("Forbidden value (" + this.regenRate + ") on element of PartyMemberInformations.regenRate.");
    }

    private void _initiativeFunc(ICustomDataInput param1) {
         this.initiative = param1.readVarUhShort();
         if(this.initiative < 0)
            throw new Exception("Forbidden value (" + this.initiative + ") on element of PartyMemberInformations.initiative.");
    }

    private void _alignmentSideFunc(ICustomDataInput param1) {
         this.alignmentSide = param1.readByte();
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element of PartyMemberInformations.worldX.");
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
            throw new Exception("Forbidden value (" + this.worldY + ") on element of PartyMemberInformations.worldY.");
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PartyMemberInformations.subAreaId.");
    }

    private void _statustreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserializeAsync(this._statustree);
    }

    private void _companionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._companionstree.addChild(this._companionsFunc);
            _loc3_++;
    }

    private void _companionsFunc(ICustomDataInput param1) {
         PartyCompanionMemberInformations _loc2_ = new PartyCompanionMemberInformations();
         _loc2_.deserialize(param1);
         this.companions.push(_loc2_);
    }

}