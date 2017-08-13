package package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockToSellListRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6141;
    private boolean _isInitialized = false;
    private int pageIndex = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6141;
    }

    public PaddockToSellListRequestMessage initPaddockToSellListRequestMessage(int param1) {
         this.pageIndex = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.pageIndex = 0;
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
         this.serializeAs_PaddockToSellListRequestMessage(param1);
    }

    public void serializeAs_PaddockToSellListRequestMessage(ICustomDataOutput param1) {
         if(this.pageIndex < 0)
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element pageIndex.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockToSellListRequestMessage(param1);
    }

    public void deserializeAs_PaddockToSellListRequestMessage(ICustomDataInput param1) {
         this._pageIndexFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockToSellListRequestMessage(param1);
    }

    public void deserializeAsyncAs_PaddockToSellListRequestMessage(FuncTree param1) {
         param1.addChild(this._pageIndexFunc);
    }

    private void _pageIndexFunc(ICustomDataInput param1) {
         this.pageIndex = param1.readVarUhShort();
         if(this.pageIndex < 0)
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element of PaddockToSellListRequestMessage.pageIndex.");
    }

}