package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeObjectTransfertListFromInvMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6183;
    private boolean _isInitialized = false;
    private Vector.<uint> ids = ;
    private FuncTree _idstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6183;
    }

    public ExchangeObjectTransfertListFromInvMessage initExchangeObjectTransfertListFromInvMessage(Vector.<uint> param1) {
         this.ids = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.ids = new Vector.<uint>();
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
         this.serializeAs_ExchangeObjectTransfertListFromInvMessage(param1);
    }

    public void serializeAs_ExchangeObjectTransfertListFromInvMessage(ICustomDataOutput param1) {
         param1.writeShort(this.ids.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ids.length)
            if(this.ids[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.ids[_loc2_] + ") on element 1 (starting at 1) of ids.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectTransfertListFromInvMessage(param1);
    }

    public void deserializeAs_ExchangeObjectTransfertListFromInvMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhInt();
            if(_loc4_ < 0)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of ids.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeObjectTransfertListFromInvMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeObjectTransfertListFromInvMessage(FuncTree param1) {
         this._idstree = param1.addChild(this._idstreeFunc);
    }

    private void _idstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._idstree.addChild(this._idsFunc);
            _loc3_++;
    }

    private void _idsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of ids.");
    }

}