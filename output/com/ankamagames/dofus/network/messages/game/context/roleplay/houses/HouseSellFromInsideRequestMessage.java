package package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseSellFromInsideRequestMessage extends HouseSellRequestMessage implements INetworkMessage {

    private int protocolId = 5884;
    private boolean _isInitialized = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5884;
    }

    public HouseSellFromInsideRequestMessage initHouseSellFromInsideRequestMessage(int param1,Number  param2,boolean  param3) {
         super.initHouseSellRequestMessage(param1,param2,param3);
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
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
         this.serializeAs_HouseSellFromInsideRequestMessage(param1);
    }

    public void serializeAs_HouseSellFromInsideRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_HouseSellRequestMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseSellFromInsideRequestMessage(param1);
    }

    public void deserializeAs_HouseSellFromInsideRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseSellFromInsideRequestMessage(param1);
    }

    public void deserializeAsyncAs_HouseSellFromInsideRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}