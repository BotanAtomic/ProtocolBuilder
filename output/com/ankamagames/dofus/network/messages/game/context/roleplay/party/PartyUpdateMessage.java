package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyMemberInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class PartyUpdateMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 5575;
    private boolean _isInitialized = false;
    private PartyMemberInformations memberInformations = ;
    private FuncTree _memberInformationstree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5575;
    }

    public PartyUpdateMessage initPartyUpdateMessage(int param1,PartyMemberInformations  param2) {
         super.initAbstractPartyEventMessage(param1);
         this.memberInformations = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.memberInformations = new PartyMemberInformations();
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
         this.serializeAs_PartyUpdateMessage(param1);
    }

    public void serializeAs_PartyUpdateMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyEventMessage(param1);
         param1.writeShort(this.memberInformations.getTypeId());
         this.memberInformations.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyUpdateMessage(param1);
    }

    public void deserializeAs_PartyUpdateMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.memberInformations = ProtocolTypeManager.getInstance(PartyMemberInformations,_loc2_);
         this.memberInformations.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyUpdateMessage(param1);
    }

    public void deserializeAsyncAs_PartyUpdateMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._memberInformationstree = param1.addChild(this._memberInformationstreeFunc);
    }

    private void _memberInformationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.memberInformations = ProtocolTypeManager.getInstance(PartyMemberInformations,_loc2_);
         this.memberInformations.deserializeAsync(this._memberInformationstree);
    }

}