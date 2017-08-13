package package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class IgnoredDeleteRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5680;
    private boolean _isInitialized = false;
    private int accountId = 0;
    private boolean session = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5680;
    }

    public IgnoredDeleteRequestMessage initIgnoredDeleteRequestMessage(int param1,boolean  param2) {
         this.accountId = param1;
         this.session = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.accountId = 0;
         this.session = false;
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
         this.serializeAs_IgnoredDeleteRequestMessage(param1);
    }

    public void serializeAs_IgnoredDeleteRequestMessage(ICustomDataOutput param1) {
         if(this.accountId < 0)
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IgnoredDeleteRequestMessage(param1);
    }

    public void deserializeAs_IgnoredDeleteRequestMessage(ICustomDataInput param1) {
         this._accountIdFunc(param1);
         this._sessionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IgnoredDeleteRequestMessage(param1);
    }

    public void deserializeAsyncAs_IgnoredDeleteRequestMessage(FuncTree param1) {
         param1.addChild(this._accountIdFunc);
         param1.addChild(this._sessionFunc);
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
            throw new Exception("Forbidden value (" + this.accountId + ") on element of IgnoredDeleteRequestMessage.accountId.");
    }

    private void _sessionFunc(ICustomDataInput param1) {
         this.session = param1.readBoolean();
    }

}