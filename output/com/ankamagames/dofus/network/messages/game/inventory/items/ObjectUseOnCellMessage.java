package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectUseOnCellMessage extends ObjectUseMessage implements INetworkMessage {

    private int protocolId = 3013;
    private boolean _isInitialized = false;
    private int cells = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 3013;
    }

    public ObjectUseOnCellMessage initObjectUseOnCellMessage(int param1,int  param2) {
         super.initObjectUseMessage(param1);
         this.cells = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.cells = 0;
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
         this.serializeAs_ObjectUseOnCellMessage(param1);
    }

    public void serializeAs_ObjectUseOnCellMessage(ICustomDataOutput param1) {
         super.serializeAs_ObjectUseMessage(param1);
         if(this.cells < 0 || this.cells > 559)
            throw new Exception("Forbidden value (" + this.cells + ") on element cells.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectUseOnCellMessage(param1);
    }

    public void deserializeAs_ObjectUseOnCellMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._cellsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectUseOnCellMessage(param1);
    }

    public void deserializeAsyncAs_ObjectUseOnCellMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._cellsFunc);
    }

    private void _cellsFunc(ICustomDataInput param1) {
         this.cells = param1.readVarUhShort();
         if(this.cells < 0 || this.cells > 559)
            throw new Exception("Forbidden value (" + this.cells + ") on element of ObjectUseOnCellMessage.cells.");
    }

}