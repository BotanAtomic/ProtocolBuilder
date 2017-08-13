package com.ankamagames.dofus.network.messages.security;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CheckFileRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6154;
    private boolean _isInitialized = false;
    private String filename = "";
    private int type = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6154;
    }

    public CheckFileRequestMessage initCheckFileRequestMessage(String param1,int  param2) {
         this.filename = param1;
         this.type = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.filename = "";
         this.type = 0;
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
         this.serializeAs_CheckFileRequestMessage(param1);
    }

    public void serializeAs_CheckFileRequestMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.filename);
         param1.writeByte(this.type);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CheckFileRequestMessage(param1);
    }

    public void deserializeAs_CheckFileRequestMessage(ICustomDataInput param1) {
         this._filenameFunc(param1);
         this._typeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CheckFileRequestMessage(param1);
    }

    public void deserializeAsyncAs_CheckFileRequestMessage(FuncTree param1) {
         param1.addChild(this._filenameFunc);
         param1.addChild(this._typeFunc);
    }

    private void _filenameFunc(ICustomDataInput param1) {
         this.filename = param1.readUTF();
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of CheckFileRequestMessage.type.");
         }
    }

}