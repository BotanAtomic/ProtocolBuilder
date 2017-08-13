package package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyMemberGeoPosition extends Object implements INetworkType {

    private int protocolId = 378;
    private int memberId = 0;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;


    public int getTypeId() {
         return 378;
    }

    public PartyMemberGeoPosition initPartyMemberGeoPosition(int param1,int  param2,int  param3,int  param4,int  param5) {
         this.memberId = param1;
         this.worldX = param2;
         this.worldY = param3;
         this.mapId = param4;
         this.subAreaId = param5;
         return this;
    }

    public void reset() {
         this.memberId = 0;
         this.worldX = 0;
         this.worldY = 0;
         this.mapId = 0;
         this.subAreaId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyMemberGeoPosition(param1);
    }

    public void serializeAs_PartyMemberGeoPosition(ICustomDataOutput param1) {
         if(this.memberId < 0)
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyMemberGeoPosition(param1);
    }

    public void deserializeAs_PartyMemberGeoPosition(ICustomDataInput param1) {
         this._memberIdFunc(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyMemberGeoPosition(param1);
    }

    public void deserializeAsyncAs_PartyMemberGeoPosition(FuncTree param1) {
         param1.addChild(this._memberIdFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._subAreaIdFunc);
    }

    private void _memberIdFunc(ICustomDataInput param1) {
         this.memberId = param1.readInt();
         if(this.memberId < 0)
            throw new Exception("Forbidden value (" + this.memberId + ") on element of PartyMemberGeoPosition.memberId.");
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element of PartyMemberGeoPosition.worldX.");
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
            throw new Exception("Forbidden value (" + this.worldY + ") on element of PartyMemberGeoPosition.worldY.");
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PartyMemberGeoPosition.subAreaId.");
    }

}