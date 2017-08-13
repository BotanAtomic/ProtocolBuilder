package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.MountClientData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeMountsStableAddMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6555;
    private boolean _isInitialized = false;
    private Vector.<MountClientData> mountDescription = ;
    private FuncTree _mountDescriptiontree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6555;
    }

    public ExchangeMountsStableAddMessage initExchangeMountsStableAddMessage(Vector.<MountClientData> param1) {
         this.mountDescription = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mountDescription = new Vector.<MountClientData>();
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
         this.serializeAs_ExchangeMountsStableAddMessage(param1);
    }

    public void serializeAs_ExchangeMountsStableAddMessage(ICustomDataOutput param1) {
         param1.writeShort(this.mountDescription.length);
         int _loc2_ = 0;
         while(_loc2_ < this.mountDescription.length)
            (this.mountDescription[_loc2_] as MountClientData).serializeAs_MountClientData(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeMountsStableAddMessage(param1);
    }

    public void deserializeAs_ExchangeMountsStableAddMessage(ICustomDataInput param1) {
         MountClientData _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new MountClientData();
            _loc4_.deserialize(param1);
            this.mountDescription.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeMountsStableAddMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeMountsStableAddMessage(FuncTree param1) {
         this._mountDescriptiontree = param1.addChild(this._mountDescriptiontreeFunc);
    }

    private void _mountDescriptiontreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._mountDescriptiontree.addChild(this._mountDescriptionFunc);
            _loc3_++;
    }

    private void _mountDescriptionFunc(ICustomDataInput param1) {
         MountClientData _loc2_ = new MountClientData();
         _loc2_.deserialize(param1);
         this.mountDescription.push(_loc2_);
    }

}