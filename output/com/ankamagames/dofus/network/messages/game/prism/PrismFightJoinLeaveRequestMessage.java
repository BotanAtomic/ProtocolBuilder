package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PrismFightJoinLeaveRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5843;
    private boolean _isInitialized = false;
    private int subAreaId = 0;
    private boolean join = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5843;
    }

    public PrismFightJoinLeaveRequestMessage initPrismFightJoinLeaveRequestMessage(int param1,boolean  param2) {
         this.subAreaId = param1;
         this.join = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.subAreaId = 0;
         this.join = false;
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
         this.serializeAs_PrismFightJoinLeaveRequestMessage(param1);
    }

    public void serializeAs_PrismFightJoinLeaveRequestMessage(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         param1.writeBoolean(this.join);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismFightJoinLeaveRequestMessage(param1);
    }

    public void deserializeAs_PrismFightJoinLeaveRequestMessage(ICustomDataInput param1) {
         this._subAreaIdFunc(param1);
         this._joinFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismFightJoinLeaveRequestMessage(param1);
    }

    public void deserializeAsyncAs_PrismFightJoinLeaveRequestMessage(FuncTree param1) {
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._joinFunc);
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PrismFightJoinLeaveRequestMessage.subAreaId.");
         }
    }

    private void _joinFunc(ICustomDataInput param1) {
         this.join = param1.readBoolean();
    }

}