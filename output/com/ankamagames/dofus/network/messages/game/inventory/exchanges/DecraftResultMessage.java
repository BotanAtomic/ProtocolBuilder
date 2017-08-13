package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.DecraftedItemStackInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DecraftResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6569;
    private boolean _isInitialized = false;
    private Vector.<DecraftedItemStackInfo> results = ;
    private FuncTree _resultstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6569;
    }

    public DecraftResultMessage initDecraftResultMessage(Vector.<DecraftedItemStackInfo> param1) {
         this.results = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.results = new Vector.<DecraftedItemStackInfo>();
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
         this.serializeAs_DecraftResultMessage(param1);
    }

    public void serializeAs_DecraftResultMessage(ICustomDataOutput param1) {
         param1.writeShort(this.results.length);
         int _loc2_ = 0;
         while(_loc2_ < this.results.length)
            (this.results[_loc2_] as DecraftedItemStackInfo).serializeAs_DecraftedItemStackInfo(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DecraftResultMessage(param1);
    }

    public void deserializeAs_DecraftResultMessage(ICustomDataInput param1) {
         DecraftedItemStackInfo _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new DecraftedItemStackInfo();
            _loc4_.deserialize(param1);
            this.results.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DecraftResultMessage(param1);
    }

    public void deserializeAsyncAs_DecraftResultMessage(FuncTree param1) {
         this._resultstree = param1.addChild(this._resultstreeFunc);
    }

    private void _resultstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._resultstree.addChild(this._resultsFunc);
            _loc3_++;
    }

    private void _resultsFunc(ICustomDataInput param1) {
         DecraftedItemStackInfo _loc2_ = new DecraftedItemStackInfo();
         _loc2_.deserialize(param1);
         this.results.push(_loc2_);
    }

}