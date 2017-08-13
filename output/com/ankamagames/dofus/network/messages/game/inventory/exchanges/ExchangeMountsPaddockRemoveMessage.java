package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeMountsPaddockRemoveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6559;
    private boolean _isInitialized = false;
    private Vector<int> mountsId;
    private FuncTree _mountsIdtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6559;
    }

    public ExchangeMountsPaddockRemoveMessage initExchangeMountsPaddockRemoveMessage(Vector<int> param1) {
         this.mountsId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mountsId = new Vector.<int>();
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
         this.serializeAs_ExchangeMountsPaddockRemoveMessage(param1);
    }

    public void serializeAs_ExchangeMountsPaddockRemoveMessage(ICustomDataOutput param1) {
         param1.writeShort(this.mountsId.length);
         int _loc2_ = 0;
         while(_loc2_ < this.mountsId.length)
         {
            param1.writeVarInt(this.mountsId[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeMountsPaddockRemoveMessage(param1);
    }

    public void deserializeAs_ExchangeMountsPaddockRemoveMessage(ICustomDataInput param1) {
         * _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarInt();
            this.mountsId.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeMountsPaddockRemoveMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeMountsPaddockRemoveMessage(FuncTree param1) {
         this._mountsIdtree = param1.addChild(this._mountsIdtreeFunc);
    }

    private void _mountsIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._mountsIdtree.addChild(this._mountsIdFunc);
            _loc3_++;
         }
    }

    private void _mountsIdFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         this.mountsId.push(_loc2_);
    }

}