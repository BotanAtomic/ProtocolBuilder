package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeObjectTransfertListWithQuantityToInvMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6470;
    private boolean _isInitialized = false;
    private Vector<uint> ids;
    private Vector<uint> qtys;
    private FuncTree _idstree;
    private FuncTree _qtystree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6470;
    }

    public ExchangeObjectTransfertListWithQuantityToInvMessage initExchangeObjectTransfertListWithQuantityToInvMessage(Vector<uint> param1,Vector<uint>  param2) {
         this.ids = param1;
         this.qtys = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.ids = new Vector.<uint>();
         this.qtys = new Vector.<uint>();
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
         this.serializeAs_ExchangeObjectTransfertListWithQuantityToInvMessage(param1);
    }

    public void serializeAs_ExchangeObjectTransfertListWithQuantityToInvMessage(ICustomDataOutput param1) {
         param1.writeShort(this.ids.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ids.length)
         {
            if(this.ids[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.ids[_loc2_] + ") on element 1 (starting at 1) of ids.");
            }
            param1.writeVarInt(this.ids[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.qtys.length);
         int _loc3_ = 0;
         while(_loc3_ < this.qtys.length)
         {
            if(this.qtys[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.qtys[_loc3_] + ") on element 2 (starting at 1) of qtys.");
            }
            param1.writeVarInt(this.qtys[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectTransfertListWithQuantityToInvMessage(param1);
    }

    public void deserializeAs_ExchangeObjectTransfertListWithQuantityToInvMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhInt();
            if(_loc6_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of ids.");
            }
            this.ids.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhInt();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of qtys.");
            }
            this.qtys.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeObjectTransfertListWithQuantityToInvMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeObjectTransfertListWithQuantityToInvMessage(FuncTree param1) {
         this._idstree = param1.addChild(this._idstreeFunc);
         this._qtystree = param1.addChild(this._qtystreeFunc);
    }

    private void _idstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._idstree.addChild(this._idsFunc);
            _loc3_++;
         }
    }

    private void _idsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of ids.");
         }
         this.ids.push(_loc2_);
    }

    private void _qtystreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._qtystree.addChild(this._qtysFunc);
            _loc3_++;
         }
    }

    private void _qtysFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of qtys.");
         }
         this.qtys.push(_loc2_);
    }

}