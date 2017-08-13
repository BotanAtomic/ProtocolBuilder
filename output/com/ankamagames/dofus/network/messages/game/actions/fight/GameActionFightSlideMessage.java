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

public class GameActionFightSlideMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5525;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int startCellId = 0;
    private int endCellId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5525;
    }

    public GameActionFightSlideMessage initGameActionFightSlideMessage(int param1,Number  param2,Number  param3,int  param4,int  param5) {
         super.initAbstractGameActionMessage(param1,param2);
         this.targetId = param3;
         this.startCellId = param4;
         this.endCellId = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.targetId = 0;
         this.startCellId = 0;
         this.endCellId = 0;
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
         this.serializeAs_GameActionFightSlideMessage(param1);
    }

    public void serializeAs_GameActionFightSlideMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.startCellId < -1 || this.startCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.startCellId + ") on element startCellId.");
         }
         param1.writeShort(this.startCellId);
         if(this.endCellId < -1 || this.endCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.endCellId + ") on element endCellId.");
         }
         param1.writeShort(this.endCellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightSlideMessage(param1);
    }

    public void deserializeAs_GameActionFightSlideMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._targetIdFunc(param1);
         this._startCellIdFunc(param1);
         this._endCellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightSlideMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightSlideMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._startCellIdFunc);
         param1.addChild(this._endCellIdFunc);
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameActionFightSlideMessage.targetId.");
         }
    }

    private void _startCellIdFunc(ICustomDataInput param1) {
         this.startCellId = param1.readShort();
         if(this.startCellId < -1 || this.startCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.startCellId + ") on element of GameActionFightSlideMessage.startCellId.");
         }
    }

    private void _endCellIdFunc(ICustomDataInput param1) {
         this.endCellId = param1.readShort();
         if(this.endCellId < -1 || this.endCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.endCellId + ") on element of GameActionFightSlideMessage.endCellId.");
         }
    }

}