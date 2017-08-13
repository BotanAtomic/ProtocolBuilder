package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.MountClientData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartOkMountWithOutPaddockMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5991;
    private boolean _isInitialized = false;
    private Vector.<MountClientData> stabledMountsDescription = ;
    private FuncTree _stabledMountsDescriptiontree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5991;
    }

    public ExchangeStartOkMountWithOutPaddockMessage initExchangeStartOkMountWithOutPaddockMessage(Vector.<MountClientData> param1) {
         this.stabledMountsDescription = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.stabledMountsDescription = new Vector.<MountClientData>();
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
         this.serializeAs_ExchangeStartOkMountWithOutPaddockMessage(param1);
    }

    public void serializeAs_ExchangeStartOkMountWithOutPaddockMessage(ICustomDataOutput param1) {
         param1.writeShort(this.stabledMountsDescription.length);
         int _loc2_ = 0;
         while(_loc2_ < this.stabledMountsDescription.length)
            (this.stabledMountsDescription[_loc2_] as MountClientData).serializeAs_MountClientData(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartOkMountWithOutPaddockMessage(param1);
    }

    public void deserializeAs_ExchangeStartOkMountWithOutPaddockMessage(ICustomDataInput param1) {
         MountClientData _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new MountClientData();
            _loc4_.deserialize(param1);
            this.stabledMountsDescription.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartOkMountWithOutPaddockMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartOkMountWithOutPaddockMessage(FuncTree param1) {
         this._stabledMountsDescriptiontree = param1.addChild(this._stabledMountsDescriptiontreeFunc);
    }

    private void _stabledMountsDescriptiontreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._stabledMountsDescriptiontree.addChild(this._stabledMountsDescriptionFunc);
            _loc3_++;
    }

    private void _stabledMountsDescriptionFunc(ICustomDataInput param1) {
         MountClientData _loc2_ = new MountClientData();
         _loc2_.deserialize(param1);
         this.stabledMountsDescription.push(_loc2_);
    }

}