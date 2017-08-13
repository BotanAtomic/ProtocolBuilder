package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.GoldItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GoldAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6030;
    private boolean _isInitialized = false;
    private GoldItem gold;
    private FuncTree _goldtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6030;
    }

    public GoldAddedMessage initGoldAddedMessage(GoldItem param1) {
         this.gold = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.gold = new GoldItem();
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
         this.serializeAs_GoldAddedMessage(param1);
    }

    public void serializeAs_GoldAddedMessage(ICustomDataOutput param1) {
         this.gold.serializeAs_GoldItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GoldAddedMessage(param1);
    }

    public void deserializeAs_GoldAddedMessage(ICustomDataInput param1) {
         this.gold = new GoldItem();
         this.gold.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GoldAddedMessage(param1);
    }

    public void deserializeAsyncAs_GoldAddedMessage(FuncTree param1) {
         this._goldtree = param1.addChild(this._goldtreeFunc);
    }

    private void _goldtreeFunc(ICustomDataInput param1) {
         this.gold = new GoldItem();
         this.gold.deserializeAsync(this._goldtree);
    }

}