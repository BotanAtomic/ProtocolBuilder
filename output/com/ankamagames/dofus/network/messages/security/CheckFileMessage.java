package com.ankamagames.dofus.network.messages.security;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CheckFileMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6156;
    private boolean _isInitialized = false;
    private String filenameHash = "";
    private int type = 0;
    private String value = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6156;
    }

    public CheckFileMessage initCheckFileMessage(String param1,int  param2,String  param3) {
         this.filenameHash = param1;
         this.type = param2;
         this.value = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.filenameHash = "";
         this.type = 0;
         this.value = "";
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
         this.serializeAs_CheckFileMessage(param1);
    }

    public void serializeAs_CheckFileMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.filenameHash);
         param1.writeByte(this.type);
         param1.writeUTF(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CheckFileMessage(param1);
    }

    public void deserializeAs_CheckFileMessage(ICustomDataInput param1) {
         this._filenameHashFunc(param1);
         this._typeFunc(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CheckFileMessage(param1);
    }

    public void deserializeAsyncAs_CheckFileMessage(FuncTree param1) {
         param1.addChild(this._filenameHashFunc);
         param1.addChild(this._typeFunc);
         param1.addChild(this._valueFunc);
    }

    private void _filenameHashFunc(ICustomDataInput param1) {
         this.filenameHash = param1.readUTF();
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of CheckFileMessage.type.");
         }
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readUTF();
    }

}