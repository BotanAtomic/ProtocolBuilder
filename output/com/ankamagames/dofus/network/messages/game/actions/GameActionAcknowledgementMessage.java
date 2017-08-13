package com.ankamagames.dofus.network.messages.game.actions;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionAcknowledgementMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 957;
    private boolean _isInitialized = false;
    private boolean valid = false;
    private int actionId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 957;
    }

    public GameActionAcknowledgementMessage initGameActionAcknowledgementMessage(boolean param1,int  param2) {
         this.valid = param1;
         this.actionId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.valid = false;
         this.actionId = 0;
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
         this.serializeAs_GameActionAcknowledgementMessage(param1);
    }

    public void serializeAs_GameActionAcknowledgementMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.valid);
         param1.writeByte(this.actionId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionAcknowledgementMessage(param1);
    }

    public void deserializeAs_GameActionAcknowledgementMessage(ICustomDataInput param1) {
         this._validFunc(param1);
         this._actionIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionAcknowledgementMessage(param1);
    }

    public void deserializeAsyncAs_GameActionAcknowledgementMessage(FuncTree param1) {
         param1.addChild(this._validFunc);
         param1.addChild(this._actionIdFunc);
    }

    private void _validFunc(ICustomDataInput param1) {
         this.valid = param1.readBoolean();
    }

    private void _actionIdFunc(ICustomDataInput param1) {
         this.actionId = param1.readByte();
    }

}