package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightLifeAndShieldPointsLostMessage extends GameActionFightLifePointsLostMessage implements INetworkMessage {

    private int protocolId = 6310;
    private boolean _isInitialized = false;
    private int shieldLoss = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6310;
    }

    public GameActionFightLifeAndShieldPointsLostMessage initGameActionFightLifeAndShieldPointsLostMessage(int param1,Number  param2,Number  param3,int  param4,int  param5,int  param6) {
         super.initGameActionFightLifePointsLostMessage(param1,param2,param3,param4,param5);
         this.shieldLoss = param6;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.shieldLoss = 0;
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
         this.serializeAs_GameActionFightLifeAndShieldPointsLostMessage(param1);
    }

    public void serializeAs_GameActionFightLifeAndShieldPointsLostMessage(ICustomDataOutput param1) {
         super.serializeAs_GameActionFightLifePointsLostMessage(param1);
         if(this.shieldLoss < 0)
         {
            throw new Exception("Forbidden value (" + this.shieldLoss + ") on element shieldLoss.");
         }
         param1.writeVarShort(this.shieldLoss);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightLifeAndShieldPointsLostMessage(param1);
    }

    public void deserializeAs_GameActionFightLifeAndShieldPointsLostMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._shieldLossFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightLifeAndShieldPointsLostMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightLifeAndShieldPointsLostMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._shieldLossFunc);
    }

    private void _shieldLossFunc(ICustomDataInput param1) {
         this.shieldLoss = param1.readVarUhShort();
         if(this.shieldLoss < 0)
         {
            throw new Exception("Forbidden value (" + this.shieldLoss + ") on element of GameActionFightLifeAndShieldPointsLostMessage.shieldLoss.");
         }
    }

}