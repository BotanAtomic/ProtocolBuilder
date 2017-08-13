package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class DareSubscribeRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6666;
    private boolean _isInitialized = false;
    private Number dareId = 0;
    private boolean subscribe = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6666;
    }

    public DareSubscribeRequestMessage initDareSubscribeRequestMessage(Number param1,boolean  param2) {
         this.dareId = param1;
         this.subscribe = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dareId = 0;
         this.subscribe = false;
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
         this.serializeAs_DareSubscribeRequestMessage(param1);
    }

    public void serializeAs_DareSubscribeRequestMessage(ICustomDataOutput param1) {
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
         param1.writeBoolean(this.subscribe);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareSubscribeRequestMessage(param1);
    }

    public void deserializeAs_DareSubscribeRequestMessage(ICustomDataInput param1) {
         this._dareIdFunc(param1);
         this._subscribeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareSubscribeRequestMessage(param1);
    }

    public void deserializeAsyncAs_DareSubscribeRequestMessage(FuncTree param1) {
         param1.addChild(this._dareIdFunc);
         param1.addChild(this._subscribeFunc);
    }

    private void _dareIdFunc(ICustomDataInput param1) {
         this.dareId = param1.readDouble();
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareSubscribeRequestMessage.dareId.");
         }
    }

    private void _subscribeFunc(ICustomDataInput param1) {
         this.subscribe = param1.readBoolean();
    }

}