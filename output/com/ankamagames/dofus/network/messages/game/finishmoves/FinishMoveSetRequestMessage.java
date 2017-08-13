package com.ankamagames.dofus.network.messages.game.finishmoves;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FinishMoveSetRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6703;
    private boolean _isInitialized = false;
    private int finishMoveId = 0;
    private boolean finishMoveState = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6703;
    }

    public FinishMoveSetRequestMessage initFinishMoveSetRequestMessage(int param1,boolean  param2) {
         this.finishMoveId = param1;
         this.finishMoveState = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.finishMoveId = 0;
         this.finishMoveState = false;
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
         this.serializeAs_FinishMoveSetRequestMessage(param1);
    }

    public void serializeAs_FinishMoveSetRequestMessage(ICustomDataOutput param1) {
         if(this.finishMoveId < 0)
         {
            throw new Exception("Forbidden value (" + this.finishMoveId + ") on element finishMoveId.");
         }
         param1.writeInt(this.finishMoveId);
         param1.writeBoolean(this.finishMoveState);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FinishMoveSetRequestMessage(param1);
    }

    public void deserializeAs_FinishMoveSetRequestMessage(ICustomDataInput param1) {
         this._finishMoveIdFunc(param1);
         this._finishMoveStateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FinishMoveSetRequestMessage(param1);
    }

    public void deserializeAsyncAs_FinishMoveSetRequestMessage(FuncTree param1) {
         param1.addChild(this._finishMoveIdFunc);
         param1.addChild(this._finishMoveStateFunc);
    }

    private void _finishMoveIdFunc(ICustomDataInput param1) {
         this.finishMoveId = param1.readInt();
         if(this.finishMoveId < 0)
         {
            throw new Exception("Forbidden value (" + this.finishMoveId + ") on element of FinishMoveSetRequestMessage.finishMoveId.");
         }
    }

    private void _finishMoveStateFunc(ICustomDataInput param1) {
         this.finishMoveState = param1.readBoolean();
    }

}