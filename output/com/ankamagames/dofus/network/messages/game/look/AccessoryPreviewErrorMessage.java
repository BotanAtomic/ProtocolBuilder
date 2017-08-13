package package com.ankamagames.dofus.network.messages.game.look;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AccessoryPreviewErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6521;
    private boolean _isInitialized = false;
    private int error = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6521;
    }

    public AccessoryPreviewErrorMessage initAccessoryPreviewErrorMessage(int param1) {
         this.error = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.error = 0;
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
         this.serializeAs_AccessoryPreviewErrorMessage(param1);
    }

    public void serializeAs_AccessoryPreviewErrorMessage(ICustomDataOutput param1) {
         param1.writeByte(this.error);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AccessoryPreviewErrorMessage(param1);
    }

    public void deserializeAs_AccessoryPreviewErrorMessage(ICustomDataInput param1) {
         this._errorFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AccessoryPreviewErrorMessage(param1);
    }

    public void deserializeAsyncAs_AccessoryPreviewErrorMessage(FuncTree param1) {
         param1.addChild(this._errorFunc);
    }

    private void _errorFunc(ICustomDataInput param1) {
         this.error = param1.readByte();
         if(this.error < 0)
            throw new Exception("Forbidden value (" + this.error + ") on element of AccessoryPreviewErrorMessage.error.");
    }

}