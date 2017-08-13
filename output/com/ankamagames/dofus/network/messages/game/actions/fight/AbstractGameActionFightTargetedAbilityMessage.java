package package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class AbstractGameActionFightTargetedAbilityMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 6118;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int destinationCellId = 0;
    private int critical = 1;
    private boolean silentCast = false;
    private boolean verboseCast = false;
    private int _loc2_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6118;
    }

    public AbstractGameActionFightTargetedAbilityMessage initAbstractGameActionFightTargetedAbilityMessage(int param1,Number  param2,Number  param3,int  param4,int  param5,boolean  param6,boolean  param7) {
         super.initAbstractGameActionMessage(param1,param2);
         this.targetId = param3;
         this.destinationCellId = param4;
         this.critical = param5;
         this.silentCast = param6;
         this.verboseCast = param7;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.targetId = 0;
         this.destinationCellId = 0;
         this.critical = 1;
         this.silentCast = false;
         this.verboseCast = false;
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
         this.serializeAs_AbstractGameActionFightTargetedAbilityMessage(param1);
    }

    public void serializeAs_AbstractGameActionFightTargetedAbilityMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.silentCast);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.verboseCast);
         param1.writeByte(_loc2_);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractGameActionFightTargetedAbilityMessage(param1);
    }

    public void deserializeAs_AbstractGameActionFightTargetedAbilityMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.deserializeByteBoxes(param1);
         this._targetIdFunc(param1);
         this._destinationCellIdFunc(param1);
         this._criticalFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractGameActionFightTargetedAbilityMessage(param1);
    }

    public void deserializeAsyncAs_AbstractGameActionFightTargetedAbilityMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._destinationCellIdFunc);
         param1.addChild(this._criticalFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.silentCast = BooleanByteWrapper.getFlag(_loc2_,0);
         this.verboseCast = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element of AbstractGameActionFightTargetedAbilityMessage.targetId.");
    }

    private void _destinationCellIdFunc(ICustomDataInput param1) {
         this.destinationCellId = param1.readShort();
         if(this.destinationCellId < -1 || this.destinationCellId > 559)
            throw new Exception("Forbidden value (" + this.destinationCellId + ") on element of AbstractGameActionFightTargetedAbilityMessage.destinationCellId.");
    }

    private void _criticalFunc(ICustomDataInput param1) {
         this.critical = param1.readByte();
         if(this.critical < 0)
            throw new Exception("Forbidden value (" + this.critical + ") on element of AbstractGameActionFightTargetedAbilityMessage.critical.");
    }

}