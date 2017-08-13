package package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ServerSelectionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 40;
    private boolean _isInitialized = false;
    private int serverId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 40;
    }

    public ServerSelectionMessage initServerSelectionMessage(int param1) {
         this.serverId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.serverId = 0;
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
         this.serializeAs_ServerSelectionMessage(param1);
    }

    public void serializeAs_ServerSelectionMessage(ICustomDataOutput param1) {
         if(this.serverId < 0)
            throw new Exception("Forbidden value (" + this.serverId + ") on element serverId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServerSelectionMessage(param1);
    }

    public void deserializeAs_ServerSelectionMessage(ICustomDataInput param1) {
         this._serverIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServerSelectionMessage(param1);
    }

    public void deserializeAsyncAs_ServerSelectionMessage(FuncTree param1) {
         param1.addChild(this._serverIdFunc);
    }

    private void _serverIdFunc(ICustomDataInput param1) {
         this.serverId = param1.readVarUhShort();
         if(this.serverId < 0)
            throw new Exception("Forbidden value (" + this.serverId + ") on element of ServerSelectionMessage.serverId.");
    }

}