package package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FriendDeleteRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5603;
    private boolean _isInitialized = false;
    private int accountId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5603;
    }

    public FriendDeleteRequestMessage initFriendDeleteRequestMessage(int param1) {
         this.accountId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.accountId = 0;
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
         this.serializeAs_FriendDeleteRequestMessage(param1);
    }

    public void serializeAs_FriendDeleteRequestMessage(ICustomDataOutput param1) {
         if(this.accountId < 0)
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FriendDeleteRequestMessage(param1);
    }

    public void deserializeAs_FriendDeleteRequestMessage(ICustomDataInput param1) {
         this._accountIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FriendDeleteRequestMessage(param1);
    }

    public void deserializeAsyncAs_FriendDeleteRequestMessage(FuncTree param1) {
         param1.addChild(this._accountIdFunc);
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
            throw new Exception("Forbidden value (" + this.accountId + ") on element of FriendDeleteRequestMessage.accountId.");
    }

}