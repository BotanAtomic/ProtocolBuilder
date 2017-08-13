package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ContactLookRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5932;
    private boolean _isInitialized = false;
    private int requestId = 0;
    private int contactType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5932;
    }

    public ContactLookRequestMessage initContactLookRequestMessage(int param1,int  param2) {
         this.requestId = param1;
         this.contactType = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.requestId = 0;
         this.contactType = 0;
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
         this.serializeAs_ContactLookRequestMessage(param1);
    }

    public void serializeAs_ContactLookRequestMessage(ICustomDataOutput param1) {
         if(this.requestId < 0 || this.requestId > 255)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeByte(this.requestId);
         param1.writeByte(this.contactType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ContactLookRequestMessage(param1);
    }

    public void deserializeAs_ContactLookRequestMessage(ICustomDataInput param1) {
         this._requestIdFunc(param1);
         this._contactTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ContactLookRequestMessage(param1);
    }

    public void deserializeAsyncAs_ContactLookRequestMessage(FuncTree param1) {
         param1.addChild(this._requestIdFunc);
         param1.addChild(this._contactTypeFunc);
    }

    private void _requestIdFunc(ICustomDataInput param1) {
         this.requestId = param1.readUnsignedByte();
         if(this.requestId < 0 || this.requestId > 255)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element of ContactLookRequestMessage.requestId.");
         }
    }

    private void _contactTypeFunc(ICustomDataInput param1) {
         this.contactType = param1.readByte();
         if(this.contactType < 0)
         {
            throw new Exception("Forbidden value (" + this.contactType + ") on element of ContactLookRequestMessage.contactType.");
         }
    }

}