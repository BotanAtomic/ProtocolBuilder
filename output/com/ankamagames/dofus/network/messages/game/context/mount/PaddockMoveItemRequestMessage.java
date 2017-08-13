package package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockMoveItemRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6052;
    private boolean _isInitialized = false;
    private int oldCellId = 0;
    private int newCellId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6052;
    }

    public PaddockMoveItemRequestMessage initPaddockMoveItemRequestMessage(int param1,int  param2) {
         this.oldCellId = param1;
         this.newCellId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.oldCellId = 0;
         this.newCellId = 0;
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
         this.serializeAs_PaddockMoveItemRequestMessage(param1);
    }

    public void serializeAs_PaddockMoveItemRequestMessage(ICustomDataOutput param1) {
         if(this.oldCellId < 0 || this.oldCellId > 559)
            throw new Exception("Forbidden value (" + this.oldCellId + ") on element oldCellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockMoveItemRequestMessage(param1);
    }

    public void deserializeAs_PaddockMoveItemRequestMessage(ICustomDataInput param1) {
         this._oldCellIdFunc(param1);
         this._newCellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockMoveItemRequestMessage(param1);
    }

    public void deserializeAsyncAs_PaddockMoveItemRequestMessage(FuncTree param1) {
         param1.addChild(this._oldCellIdFunc);
         param1.addChild(this._newCellIdFunc);
    }

    private void _oldCellIdFunc(ICustomDataInput param1) {
         this.oldCellId = param1.readVarUhShort();
         if(this.oldCellId < 0 || this.oldCellId > 559)
            throw new Exception("Forbidden value (" + this.oldCellId + ") on element of PaddockMoveItemRequestMessage.oldCellId.");
    }

    private void _newCellIdFunc(ICustomDataInput param1) {
         this.newCellId = param1.readVarUhShort();
         if(this.newCellId < 0 || this.newCellId > 559)
            throw new Exception("Forbidden value (" + this.newCellId + ") on element of PaddockMoveItemRequestMessage.newCellId.");
    }

}