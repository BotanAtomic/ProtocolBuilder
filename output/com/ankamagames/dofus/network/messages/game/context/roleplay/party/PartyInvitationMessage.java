package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyInvitationMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5586;
    private boolean _isInitialized = false;
    private int partyType = 0;
    private String partyName = "";
    private int maxParticipants = 0;
    private Number fromId = 0;
    private String fromName = "";
    private Number toId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5586;
    }

    public PartyInvitationMessage initPartyInvitationMessage(int param1,int  param2,String  param3,int  param4,Number  param5,String  param6,Number  param7) {
         super.initAbstractPartyMessage(param1);
         this.partyType = param2;
         this.partyName = param3;
         this.maxParticipants = param4;
         this.fromId = param5;
         this.fromName = param6;
         this.toId = param7;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.partyType = 0;
         this.partyName = "";
         this.maxParticipants = 0;
         this.fromId = 0;
         this.fromName = "";
         this.toId = 0;
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
         this.serializeAs_PartyInvitationMessage(param1);
    }

    public void serializeAs_PartyInvitationMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeByte(this.partyType);
         param1.writeUTF(this.partyName);
         if(this.maxParticipants < 0)
            throw new Exception("Forbidden value (" + this.maxParticipants + ") on element maxParticipants.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationMessage(param1);
    }

    public void deserializeAs_PartyInvitationMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._partyTypeFunc(param1);
         this._partyNameFunc(param1);
         this._maxParticipantsFunc(param1);
         this._fromIdFunc(param1);
         this._fromNameFunc(param1);
         this._toIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyInvitationMessage(param1);
    }

    public void deserializeAsyncAs_PartyInvitationMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._partyTypeFunc);
         param1.addChild(this._partyNameFunc);
         param1.addChild(this._maxParticipantsFunc);
         param1.addChild(this._fromIdFunc);
         param1.addChild(this._fromNameFunc);
         param1.addChild(this._toIdFunc);
    }

    private void _partyTypeFunc(ICustomDataInput param1) {
         this.partyType = param1.readByte();
         if(this.partyType < 0)
            throw new Exception("Forbidden value (" + this.partyType + ") on element of PartyInvitationMessage.partyType.");
    }

    private void _partyNameFunc(ICustomDataInput param1) {
         this.partyName = param1.readUTF();
    }

    private void _maxParticipantsFunc(ICustomDataInput param1) {
         this.maxParticipants = param1.readByte();
         if(this.maxParticipants < 0)
            throw new Exception("Forbidden value (" + this.maxParticipants + ") on element of PartyInvitationMessage.maxParticipants.");
    }

    private void _fromIdFunc(ICustomDataInput param1) {
         this.fromId = param1.readVarUhLong();
         if(this.fromId < 0 || this.fromId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.fromId + ") on element of PartyInvitationMessage.fromId.");
    }

    private void _fromNameFunc(ICustomDataInput param1) {
         this.fromName = param1.readUTF();
    }

    private void _toIdFunc(ICustomDataInput param1) {
         this.toId = param1.readVarUhLong();
         if(this.toId < 0 || this.toId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.toId + ") on element of PartyInvitationMessage.toId.");
    }

}