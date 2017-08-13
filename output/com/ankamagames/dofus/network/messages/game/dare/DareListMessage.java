package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6661;
    private boolean _isInitialized = false;
    private Vector<DareInformations> dares;
    private FuncTree _darestree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6661;
    }

    public DareListMessage initDareListMessage(Vector<DareInformations> param1) {
         this.dares = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dares = new Vector.<DareInformations>();
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
         this.serializeAs_DareListMessage(param1);
    }

    public void serializeAs_DareListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.dares.length);
         int _loc2_ = 0;
         while(_loc2_ < this.dares.length)
         {
            (this.dares[_loc2_] as DareInformations).serializeAs_DareInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareListMessage(param1);
    }

    public void deserializeAs_DareListMessage(ICustomDataInput param1) {
         DareInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new DareInformations();
            _loc4_.deserialize(param1);
            this.dares.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareListMessage(param1);
    }

    public void deserializeAsyncAs_DareListMessage(FuncTree param1) {
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
         DareInformations _loc2_ = new DareInformations();
         _loc2_.deserialize(param1);
         this.dares.push(_loc2_);
    }

}