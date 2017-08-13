package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.MountClientData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartOkMountMessage extends ExchangeStartOkMountWithOutPaddockMessage implements INetworkMessage {

    private int protocolId = 5979;
    private boolean _isInitialized = false;
    private Vector.<MountClientData> paddockedMountsDescription = ;
    private FuncTree _paddockedMountsDescriptiontree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5979;
    }

    public ExchangeStartOkMountMessage initExchangeStartOkMountMessage(Vector.<MountClientData> param1,Vector.<MountClientData>  param2) {
         super.initExchangeStartOkMountWithOutPaddockMessage(param1);
         this.paddockedMountsDescription = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.paddockedMountsDescription = new Vector.<MountClientData>();
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
         this.serializeAs_ExchangeStartOkMountMessage(param1);
    }

    public void serializeAs_ExchangeStartOkMountMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeStartOkMountWithOutPaddockMessage(param1);
         param1.writeShort(this.paddockedMountsDescription.length);
         int _loc2_ = 0;
         while(_loc2_ < this.paddockedMountsDescription.length)
            (this.paddockedMountsDescription[_loc2_] as MountClientData).serializeAs_MountClientData(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartOkMountMessage(param1);
    }

    public void deserializeAs_ExchangeStartOkMountMessage(ICustomDataInput param1) {
         MountClientData _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new MountClientData();
            _loc4_.deserialize(param1);
            this.paddockedMountsDescription.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartOkMountMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartOkMountMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._paddockedMountsDescriptiontree = param1.addChild(this._paddockedMountsDescriptiontreeFunc);
    }

    private void _paddockedMountsDescriptiontreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._paddockedMountsDescriptiontree.addChild(this._paddockedMountsDescriptionFunc);
            _loc3_++;
    }

    private void _paddockedMountsDescriptionFunc(ICustomDataInput param1) {
         MountClientData _loc2_ = new MountClientData();
         _loc2_.deserialize(param1);
         this.paddockedMountsDescription.push(_loc2_);
    }

}