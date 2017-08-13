package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyNameSetErrorMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6501;
    private boolean _isInitialized = false;
    private int result = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6501;
    }

    public PartyNameSetErrorMessage initPartyNameSetErrorMessage(int param1,int  param2) {
         super.initAbstractPartyMessage(param1);
         this.result = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.result = 0;
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
         this.serializeAs_PartyNameSetErrorMessage(param1);
    }

    public void serializeAs_PartyNameSetErrorMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeByte(this.result);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyNameSetErrorMessage(param1);
    }

    public void deserializeAs_PartyNameSetErrorMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._resultFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyNameSetErrorMessage(param1);
    }

    public void deserializeAsyncAs_PartyNameSetErrorMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._resultFunc);
    }

    private void _resultFunc(ICustomDataInput param1) {
         this.result = param1.readByte();
         if(this.result < 0)
         {
            throw new Exception("Forbidden value (" + this.result + ") on element of PartyNameSetErrorMessage.result.");
         }
    }

}