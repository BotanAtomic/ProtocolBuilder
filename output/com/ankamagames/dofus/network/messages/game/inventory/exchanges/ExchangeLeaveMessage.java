package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.dofus.network.messages.game.dialog.LeaveDialogMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeLeaveMessage extends LeaveDialogMessage implements INetworkMessage {

    private int protocolId = 5628;
    private boolean _isInitialized = false;
    private boolean success = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5628;
    }

    public ExchangeLeaveMessage initExchangeLeaveMessage(int param1,boolean  param2) {
         super.initLeaveDialogMessage(param1);
         this.success = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.success = false;
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
         this.serializeAs_ExchangeLeaveMessage(param1);
    }

    public void serializeAs_ExchangeLeaveMessage(ICustomDataOutput param1) {
         super.serializeAs_LeaveDialogMessage(param1);
         param1.writeBoolean(this.success);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeLeaveMessage(param1);
    }

    public void deserializeAs_ExchangeLeaveMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._successFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeLeaveMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeLeaveMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._successFunc);
    }

    private void _successFunc(ICustomDataInput param1) {
         this.success = param1.readBoolean();
    }

}