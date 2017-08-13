package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightDodgePointLossMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5828;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int amount = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5828;
    }

    public GameActionFightDodgePointLossMessage initGameActionFightDodgePointLossMessage(int param1,Number  param2,Number  param3,int  param4) {
         super.initAbstractGameActionMessage(param1,param2);
         this.targetId = param3;
         this.amount = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.targetId = 0;
         this.amount = 0;
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
         this.serializeAs_GameActionFightDodgePointLossMessage(param1);
    }

    public void serializeAs_GameActionFightDodgePointLossMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.amount < 0)
         {
            throw new Exception("Forbidden value (" + this.amount + ") on element amount.");
         }
         param1.writeVarShort(this.amount);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightDodgePointLossMessage(param1);
    }

    public void deserializeAs_GameActionFightDodgePointLossMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._targetIdFunc(param1);
         this._amountFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightDodgePointLossMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightDodgePointLossMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._amountFunc);
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameActionFightDodgePointLossMessage.targetId.");
         }
    }

    private void _amountFunc(ICustomDataInput param1) {
         this.amount = param1.readVarUhShort();
         if(this.amount < 0)
         {
            throw new Exception("Forbidden value (" + this.amount + ") on element of GameActionFightDodgePointLossMessage.amount.");
         }
    }

}