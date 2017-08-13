package package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class LifePointsRegenEndMessage extends UpdateLifePointsMessage implements INetworkMessage {

    private int protocolId = 5686;
    private boolean _isInitialized = false;
    private int lifePointsGained = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5686;
    }

    public LifePointsRegenEndMessage initLifePointsRegenEndMessage(int param1,int  param2,int  param3) {
         super.initUpdateLifePointsMessage(param1,param2);
         this.lifePointsGained = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.lifePointsGained = 0;
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
         this.serializeAs_LifePointsRegenEndMessage(param1);
    }

    public void serializeAs_LifePointsRegenEndMessage(ICustomDataOutput param1) {
         super.serializeAs_UpdateLifePointsMessage(param1);
         if(this.lifePointsGained < 0)
            throw new Exception("Forbidden value (" + this.lifePointsGained + ") on element lifePointsGained.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LifePointsRegenEndMessage(param1);
    }

    public void deserializeAs_LifePointsRegenEndMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._lifePointsGainedFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LifePointsRegenEndMessage(param1);
    }

    public void deserializeAsyncAs_LifePointsRegenEndMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._lifePointsGainedFunc);
    }

    private void _lifePointsGainedFunc(ICustomDataInput param1) {
         this.lifePointsGained = param1.readVarUhInt();
         if(this.lifePointsGained < 0)
            throw new Exception("Forbidden value (" + this.lifePointsGained + ") on element of LifePointsRegenEndMessage.lifePointsGained.");
    }

}