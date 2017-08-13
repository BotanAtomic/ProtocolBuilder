package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.MapCoordinatesExtended;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyMemberInFightMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6342;
    private boolean _isInitialized = false;
    private int reason = 0;
    private Number memberId = 0;
    private int memberAccountId = 0;
    private String memberName = "";
    private int fightId = 0;
    private MapCoordinatesExtended fightMap = ;
    private int timeBeforeFightStart = 0;
    private FuncTree _fightMaptree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6342;
    }

    public PartyMemberInFightMessage initPartyMemberInFightMessage(int param1,int  param2,Number  param3,int  param4,String  param5,int  param6,MapCoordinatesExtended  param7,int  param8) {
         super.initAbstractPartyMessage(param1);
         this.reason = param2;
         this.memberId = param3;
         this.memberAccountId = param4;
         this.memberName = param5;
         this.fightId = param6;
         this.fightMap = param7;
         this.timeBeforeFightStart = param8;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.reason = 0;
         this.memberId = 0;
         this.memberAccountId = 0;
         this.memberName = "";
         this.fightId = 0;
         this.fightMap = new MapCoordinatesExtended();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyMemberInFightMessage(param1);
    }

    public void serializeAs_PartyMemberInFightMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeByte(this.reason);
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyMemberInFightMessage(param1);
    }

    public void deserializeAs_PartyMemberInFightMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._reasonFunc(param1);
         this._memberIdFunc(param1);
         this._memberAccountIdFunc(param1);
         this._memberNameFunc(param1);
         this._fightIdFunc(param1);
         this.fightMap = new MapCoordinatesExtended();
         this.fightMap.deserialize(param1);
         this._timeBeforeFightStartFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyMemberInFightMessage(param1);
    }

    public void deserializeAsyncAs_PartyMemberInFightMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._reasonFunc);
         param1.addChild(this._memberIdFunc);
         param1.addChild(this._memberAccountIdFunc);
         param1.addChild(this._memberNameFunc);
         param1.addChild(this._fightIdFunc);
         this._fightMaptree = param1.addChild(this._fightMaptreeFunc);
         param1.addChild(this._timeBeforeFightStartFunc);
    }

    private void _reasonFunc(ICustomDataInput param1) {
         this.reason = param1.readByte();
         if(this.reason < 0)
            throw new Exception("Forbidden value (" + this.reason + ") on element of PartyMemberInFightMessage.reason.");
    }

    private void _memberIdFunc(ICustomDataInput param1) {
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.memberId + ") on element of PartyMemberInFightMessage.memberId.");
    }

    private void _memberAccountIdFunc(ICustomDataInput param1) {
         this.memberAccountId = param1.readInt();
         if(this.memberAccountId < 0)
            throw new Exception("Forbidden value (" + this.memberAccountId + ") on element of PartyMemberInFightMessage.memberAccountId.");
    }

    private void _memberNameFunc(ICustomDataInput param1) {
         this.memberName = param1.readUTF();
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
    }

    private void _fightMaptreeFunc(ICustomDataInput param1) {
         this.fightMap = new MapCoordinatesExtended();
         this.fightMap.deserializeAsync(this._fightMaptree);
    }

    private void _timeBeforeFightStartFunc(ICustomDataInput param1) {
         this.timeBeforeFightStart = param1.readVarShort();
    }

}