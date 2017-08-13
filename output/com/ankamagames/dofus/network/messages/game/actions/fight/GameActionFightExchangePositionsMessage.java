package package com.ankamagames.dofus.network.messages.game.actions.fight;

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

public class GameActionFightExchangePositionsMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5527;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int casterCellId = 0;
    private int targetCellId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5527;
    }

    public GameActionFightExchangePositionsMessage initGameActionFightExchangePositionsMessage(int param1,Number  param2,Number  param3,int  param4,int  param5) {
         super.initAbstractGameActionMessage(param1,param2);
         this.targetId = param3;
         this.casterCellId = param4;
         this.targetCellId = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.targetId = 0;
         this.casterCellId = 0;
         this.targetCellId = 0;
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
         this.serializeAs_GameActionFightExchangePositionsMessage(param1);
    }

    public void serializeAs_GameActionFightExchangePositionsMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightExchangePositionsMessage(param1);
    }

    public void deserializeAs_GameActionFightExchangePositionsMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._targetIdFunc(param1);
         this._casterCellIdFunc(param1);
         this._targetCellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightExchangePositionsMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightExchangePositionsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._casterCellIdFunc);
         param1.addChild(this._targetCellIdFunc);
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameActionFightExchangePositionsMessage.targetId.");
    }

    private void _casterCellIdFunc(ICustomDataInput param1) {
         this.casterCellId = param1.readShort();
         if(this.casterCellId < -1 || this.casterCellId > 559)
            throw new Exception("Forbidden value (" + this.casterCellId + ") on element of GameActionFightExchangePositionsMessage.casterCellId.");
    }

    private void _targetCellIdFunc(ICustomDataInput param1) {
         this.targetCellId = param1.readShort();
         if(this.targetCellId < -1 || this.targetCellId > 559)
            throw new Exception("Forbidden value (" + this.targetCellId + ") on element of GameActionFightExchangePositionsMessage.targetCellId.");
    }

}