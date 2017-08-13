package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorStateUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6455;
    private boolean _isInitialized = false;
    private int uniqueId = 0;
    private int state = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6455;
    }

    public TaxCollectorStateUpdateMessage initTaxCollectorStateUpdateMessage(int param1,int  param2) {
         this.uniqueId = param1;
         this.state = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.uniqueId = 0;
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
         this.serializeAs_TaxCollectorStateUpdateMessage(param1);
    }

    public void serializeAs_TaxCollectorStateUpdateMessage(ICustomDataOutput param1) {
         param1.writeInt(this.uniqueId);
         param1.writeByte(this.state);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorStateUpdateMessage(param1);
    }

    public void deserializeAs_TaxCollectorStateUpdateMessage(ICustomDataInput param1) {
         this._uniqueIdFunc(param1);
         this._stateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorStateUpdateMessage(param1);
    }

    public void deserializeAsyncAs_TaxCollectorStateUpdateMessage(FuncTree param1) {
         param1.addChild(this._uniqueIdFunc);
         param1.addChild(this._stateFunc);
    }

    private void _uniqueIdFunc(ICustomDataInput param1) {
         this.uniqueId = param1.readInt();
    }

    private void _stateFunc(ICustomDataInput param1) {
         this.state = param1.readByte();
    }

}