package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareVersatileListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6657;
    private boolean _isInitialized = false;
    private Vector<DareVersatileInformations> dares;
    private FuncTree _darestree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6657;
    }

    public DareVersatileListMessage initDareVersatileListMessage(Vector<DareVersatileInformations> param1) {
         this.dares = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dares = new Vector.<DareVersatileInformations>();
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
         this.serializeAs_DareVersatileListMessage(param1);
    }

    public void serializeAs_DareVersatileListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.dares.length);
         int _loc2_ = 0;
         while(_loc2_ < this.dares.length)
         {
            (this.dares[_loc2_] as DareVersatileInformations).serializeAs_DareVersatileInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareVersatileListMessage(param1);
    }

    public void deserializeAs_DareVersatileListMessage(ICustomDataInput param1) {
         DareVersatileInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new DareVersatileInformations();
            _loc4_.deserialize(param1);
            this.dares.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareVersatileListMessage(param1);
    }

    public void deserializeAsyncAs_DareVersatileListMessage(FuncTree param1) {
         this._darestree = param1.addChild(this._darestreeFunc);
    }

    private void _darestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._darestree.addChild(this._daresFunc);
            _loc3_++;
         }
    }

    private void _daresFunc(ICustomDataInput param1) {
         DareVersatileInformations _loc2_ = new DareVersatileInformations();
         _loc2_.deserialize(param1);
         this.dares.push(_loc2_);
    }

}