package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionBaseInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyInvitationMemberInformations extends CharacterBaseInformations implements INetworkType {

    private int protocolId = 376;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;
    private Vector<PartyCompanionBaseInformations> companions;
    private FuncTree _companionstree;


    public int getTypeId() {
         return 376;
    }

    public PartyInvitationMemberInformations initPartyInvitationMemberInformations(Number param1,String  param2,int  param3,EntityLook  param4,int  param5,boolean  param6,int  param7,int  param8,int  param9,int  param10,Vector<PartyCompanionBaseInformations>  param11) {
         super.initCharacterBaseInformations(param1,param2,param3,param4,param5,param6);
         this.worldX = param7;
         this.worldY = param8;
         this.mapId = param9;
         this.subAreaId = param10;
         this.companions = param11;
         return this;
    }

    public void reset() {
         super.reset();
         this.worldX = 0;
         this.worldY = 0;
         this.mapId = 0;
         this.subAreaId = 0;
         this.companions = new Vector.<PartyCompanionBaseInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyInvitationMemberInformations(param1);
    }

    public void serializeAs_PartyInvitationMemberInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterBaseInformations(param1);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
         param1.writeInt(this.mapId);
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         param1.writeShort(this.companions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.companions.length)
         {
            (this.companions[_loc2_] as PartyCompanionBaseInformations).serializeAs_PartyCompanionBaseInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationMemberInformations(param1);
    }

    public void deserializeAs_PartyInvitationMemberInformations(ICustomDataInput param1) {
         PartyCompanionBaseInformations _loc4_ = null;
         super.deserialize(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PartyCompanionBaseInformations();
            _loc4_.deserialize(param1);
            this.companions.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyInvitationMemberInformations(param1);
    }

    public void deserializeAsyncAs_PartyInvitationMemberInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._subAreaIdFunc);
         this._companionstree = param1.addChild(this._companionstreeFunc);
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of PartyInvitationMemberInformations.worldX.");
         }
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of PartyInvitationMemberInformations.worldY.");
         }
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PartyInvitationMemberInformations.subAreaId.");
         }
    }

    private void _companionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._companionstree.addChild(this._companionsFunc);
            _loc3_++;
         }
    }

    private void _companionsFunc(ICustomDataInput param1) {
         PartyCompanionBaseInformations _loc2_ = new PartyCompanionBaseInformations();
         _loc2_.deserialize(param1);
         this.companions.push(_loc2_);
    }

}