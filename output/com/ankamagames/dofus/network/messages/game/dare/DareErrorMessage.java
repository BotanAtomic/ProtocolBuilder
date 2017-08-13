package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DareErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6667;
    private boolean _isInitialized = false;
    private int error = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6667;
    }

    public DareErrorMessage initDareErrorMessage(int param1) {
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
         this.serializeAs_DareErrorMessage(param1);
    }

    public void serializeAs_DareErrorMessage(ICustomDataOutput param1) {
         param1.writeByte(this.error);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareErrorMessage(param1);
    }

    public void deserializeAs_DareErrorMessage(ICustomDataInput param1) {
         this._errorFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareErrorMessage(param1);
    }

    public void deserializeAsyncAs_DareErrorMessage(FuncTree param1) {
         param1.addChild(this._errorFunc);
    }

    private void _errorFunc(ICustomDataInput param1) {
         this.error = param1.readByte();
         if(this.error < 0)
         {
            throw new Exception("Forbidden value (" + this.error + ") on element of DareErrorMessage.error.");
         }
    }

}