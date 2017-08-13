package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyNameUpdateMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6502;
    private boolean _isInitialized = false;
    private String partyName = "";


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6502;
    }

    public PartyNameUpdateMessage initPartyNameUpdateMessage(int param1,String  param2) {
         super.initAbstractPartyMessage(param1);
         this.partyName = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.partyName = "";
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
         this.serializeAs_PartyNameUpdateMessage(param1);
    }

    public void serializeAs_PartyNameUpdateMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeUTF(this.partyName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyNameUpdateMessage(param1);
    }

    public void deserializeAs_PartyNameUpdateMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._partyNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyNameUpdateMessage(param1);
    }

    public void deserializeAsyncAs_PartyNameUpdateMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._partyNameFunc);
    }

    private void _partyNameFunc(ICustomDataInput param1) {
         this.partyName = param1.readUTF();
    }

}