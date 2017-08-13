package package com.ankamagames.dofus.network.messages.web.ankabox;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class MailStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6275;
    private boolean _isInitialized = false;
    private int unread = 0;
    private int total = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6275;
    }

    public MailStatusMessage initMailStatusMessage(int param1,int  param2) {
         this.unread = param1;
         this.total = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.unread = 0;
         this.total = 0;
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
         this.serializeAs_MailStatusMessage(param1);
    }

    public void serializeAs_MailStatusMessage(ICustomDataOutput param1) {
         if(this.unread < 0)
            throw new Exception("Forbidden value (" + this.unread + ") on element unread.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MailStatusMessage(param1);
    }

    public void deserializeAs_MailStatusMessage(ICustomDataInput param1) {
         this._unreadFunc(param1);
         this._totalFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MailStatusMessage(param1);
    }

    public void deserializeAsyncAs_MailStatusMessage(FuncTree param1) {
         param1.addChild(this._unreadFunc);
         param1.addChild(this._totalFunc);
    }

    private void _unreadFunc(ICustomDataInput param1) {
         this.unread = param1.readVarUhShort();
         if(this.unread < 0)
            throw new Exception("Forbidden value (" + this.unread + ") on element of MailStatusMessage.unread.");
    }

    private void _totalFunc(ICustomDataInput param1) {
         this.total = param1.readVarUhShort();
         if(this.total < 0)
            throw new Exception("Forbidden value (" + this.total + ") on element of MailStatusMessage.total.");
    }

}