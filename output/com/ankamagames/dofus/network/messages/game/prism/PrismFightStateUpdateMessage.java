package package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PrismFightStateUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6040;
    private boolean _isInitialized = false;
    private int state = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6040;
    }

    public PrismFightStateUpdateMessage initPrismFightStateUpdateMessage(int param1) {
         this.state = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.state = 0;
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
         this.serializeAs_PrismFightStateUpdateMessage(param1);
    }

    public void serializeAs_PrismFightStateUpdateMessage(ICustomDataOutput param1) {
         if(this.state < 0)
            throw new Exception("Forbidden value (" + this.state + ") on element state.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismFightStateUpdateMessage(param1);
    }

    public void deserializeAs_PrismFightStateUpdateMessage(ICustomDataInput param1) {
         this._stateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismFightStateUpdateMessage(param1);
    }

    public void deserializeAsyncAs_PrismFightStateUpdateMessage(FuncTree param1) {
         param1.addChild(this._stateFunc);
    }

    private void _stateFunc(ICustomDataInput param1) {
         this.state = param1.readByte();
         if(this.state < 0)
            throw new Exception("Forbidden value (" + this.state + ") on element of PrismFightStateUpdateMessage.state.");
    }

}