package package com.ankamagames.dofus.network.messages.debug;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DebugInClientMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6028;
    private boolean _isInitialized = false;
    private int level = 0;
    private String message = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6028;
    }

    public DebugInClientMessage initDebugInClientMessage(int param1,String  param2) {
         this.level = param1;
         this.message = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.level = 0;
         this.message = "";
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
         this.serializeAs_DebugInClientMessage(param1);
    }

    public void serializeAs_DebugInClientMessage(ICustomDataOutput param1) {
         param1.writeByte(this.level);
         param1.writeUTF(this.message);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DebugInClientMessage(param1);
    }

    public void deserializeAs_DebugInClientMessage(ICustomDataInput param1) {
         this._levelFunc(param1);
         this._messageFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DebugInClientMessage(param1);
    }

    public void deserializeAsyncAs_DebugInClientMessage(FuncTree param1) {
         param1.addChild(this._levelFunc);
         param1.addChild(this._messageFunc);
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readByte();
         if(this.level < 0)
            throw new Exception("Forbidden value (" + this.level + ") on element of DebugInClientMessage.level.");
    }

    private void _messageFunc(ICustomDataInput param1) {
         this.message = param1.readUTF();
    }

}