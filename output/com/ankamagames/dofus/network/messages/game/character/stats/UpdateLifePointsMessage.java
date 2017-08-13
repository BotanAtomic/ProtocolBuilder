package package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class UpdateLifePointsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5658;
    private boolean _isInitialized = false;
    private int lifePoints = 0;
    private int maxLifePoints = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5658;
    }

    public UpdateLifePointsMessage initUpdateLifePointsMessage(int param1,int  param2) {
         this.lifePoints = param1;
         this.maxLifePoints = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.lifePoints = 0;
         this.maxLifePoints = 0;
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
         this.serializeAs_UpdateLifePointsMessage(param1);
    }

    public void serializeAs_UpdateLifePointsMessage(ICustomDataOutput param1) {
         if(this.lifePoints < 0)
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_UpdateLifePointsMessage(param1);
    }

    public void deserializeAs_UpdateLifePointsMessage(ICustomDataInput param1) {
         this._lifePointsFunc(param1);
         this._maxLifePointsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_UpdateLifePointsMessage(param1);
    }

    public void deserializeAsyncAs_UpdateLifePointsMessage(FuncTree param1) {
         param1.addChild(this._lifePointsFunc);
         param1.addChild(this._maxLifePointsFunc);
    }

    private void _lifePointsFunc(ICustomDataInput param1) {
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of UpdateLifePointsMessage.lifePoints.");
    }

    private void _maxLifePointsFunc(ICustomDataInput param1) {
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of UpdateLifePointsMessage.maxLifePoints.");
    }

}