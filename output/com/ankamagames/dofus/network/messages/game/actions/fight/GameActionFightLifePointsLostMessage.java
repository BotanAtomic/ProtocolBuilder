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
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightLifePointsLostMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 6312;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int loss = 0;
    private int permanentDamages = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6312;
    }

    public GameActionFightLifePointsLostMessage initGameActionFightLifePointsLostMessage(int param1,Number  param2,Number  param3,int  param4,int  param5) {
         super.initAbstractGameActionMessage(param1,param2);
         this.targetId = param3;
         this.loss = param4;
         this.permanentDamages = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.targetId = 0;
         this.loss = 0;
         this.permanentDamages = 0;
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
         this.serializeAs_GameActionFightLifePointsLostMessage(param1);
    }

    public void serializeAs_GameActionFightLifePointsLostMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.loss < 0)
         {
            throw new Exception("Forbidden value (" + this.loss + ") on element loss.");
         }
         param1.writeVarInt(this.loss);
         if(this.permanentDamages < 0)
         {
            throw new Exception("Forbidden value (" + this.permanentDamages + ") on element permanentDamages.");
         }
         param1.writeVarInt(this.permanentDamages);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightLifePointsLostMessage(param1);
    }

    public void deserializeAs_GameActionFightLifePointsLostMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._targetIdFunc(param1);
         this._lossFunc(param1);
         this._permanentDamagesFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightLifePointsLostMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightLifePointsLostMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._lossFunc);
         param1.addChild(this._permanentDamagesFunc);
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameActionFightLifePointsLostMessage.targetId.");
         }
    }

    private void _lossFunc(ICustomDataInput param1) {
         this.loss = param1.readVarUhInt();
         if(this.loss < 0)
         {
            throw new Exception("Forbidden value (" + this.loss + ") on element of GameActionFightLifePointsLostMessage.loss.");
         }
    }

    private void _permanentDamagesFunc(ICustomDataInput param1) {
         this.permanentDamages = param1.readVarUhInt();
         if(this.permanentDamages < 0)
         {
            throw new Exception("Forbidden value (" + this.permanentDamages + ") on element of GameActionFightLifePointsLostMessage.permanentDamages.");
         }
    }

}