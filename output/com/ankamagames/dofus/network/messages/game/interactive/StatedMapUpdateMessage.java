package package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.StatedElement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatedMapUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5716;
    private boolean _isInitialized = false;
    private Vector.<StatedElement> statedElements = ;
    private FuncTree _statedElementstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5716;
    }

    public StatedMapUpdateMessage initStatedMapUpdateMessage(Vector.<StatedElement> param1) {
         this.statedElements = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.statedElements = new Vector.<StatedElement>();
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
         this.serializeAs_StatedMapUpdateMessage(param1);
    }

    public void serializeAs_StatedMapUpdateMessage(ICustomDataOutput param1) {
         param1.writeShort(this.statedElements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.statedElements.length)
            (this.statedElements[_loc2_] as StatedElement).serializeAs_StatedElement(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StatedMapUpdateMessage(param1);
    }

    public void deserializeAs_StatedMapUpdateMessage(ICustomDataInput param1) {
         StatedElement _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new StatedElement();
            _loc4_.deserialize(param1);
            this.statedElements.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StatedMapUpdateMessage(param1);
    }

    public void deserializeAsyncAs_StatedMapUpdateMessage(FuncTree param1) {
         this._statedElementstree = param1.addChild(this._statedElementstreeFunc);
    }

    private void _statedElementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._statedElementstree.addChild(this._statedElementsFunc);
            _loc3_++;
    }

    private void _statedElementsFunc(ICustomDataInput param1) {
         StatedElement _loc2_ = new StatedElement();
         _loc2_.deserialize(param1);
         this.statedElements.push(_loc2_);
    }

}