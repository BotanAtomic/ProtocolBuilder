package package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareCriteria;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class DareCreationRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6665;
    private boolean _isInitialized = false;
    private Number subscriptionFee = 0;
    private Number jackpot = 0;
    private int maxCountWinners = 0;
    private int delayBeforeStart = 0;
    private int duration = 0;
    private boolean isPrivate = false;
    private boolean isForGuild = false;
    private boolean isForAlliance = false;
    private boolean needNotifications = false;
    private Vector.<DareCriteria> criterions = ;
    private FuncTree _criterionstree = ;
    private int _loc3_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6665;
    }

    public DareCreationRequestMessage initDareCreationRequestMessage(Number param1,Number  param2,int  param3,int  param4,int  param5,boolean  param6,boolean  param7,boolean  param8,boolean  param9,Vector.<DareCriteria>  param10) {
         this.subscriptionFee = param1;
         this.jackpot = param2;
         this.maxCountWinners = param3;
         this.delayBeforeStart = param4;
         this.duration = param5;
         this.isPrivate = param6;
         this.isForGuild = param7;
         this.isForAlliance = param8;
         this.needNotifications = param9;
         this.criterions = param10;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.subscriptionFee = 0;
         this.jackpot = 0;
         this.maxCountWinners = 0;
         this.delayBeforeStart = 0;
         this.duration = 0;
         this.isPrivate = false;
         this.isForGuild = false;
         this.isForAlliance = false;
         this.needNotifications = false;
         this.criterions = new Vector.<DareCriteria>();
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
         this.serializeAs_DareCreationRequestMessage(param1);
    }

    public void serializeAs_DareCreationRequestMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.isPrivate);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isForGuild);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.isForAlliance);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.needNotifications);
         param1.writeByte(_loc2_);
         if(this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.subscriptionFee + ") on element subscriptionFee.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareCreationRequestMessage(param1);
    }

    public void deserializeAs_DareCreationRequestMessage(ICustomDataInput param1) {
         DareCriteria _loc4_ = null;
         this.deserializeByteBoxes(param1);
         this._subscriptionFeeFunc(param1);
         this._jackpotFunc(param1);
         this._maxCountWinnersFunc(param1);
         this._delayBeforeStartFunc(param1);
         this._durationFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new DareCriteria();
            _loc4_.deserialize(param1);
            this.criterions.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareCreationRequestMessage(param1);
    }

    public void deserializeAsyncAs_DareCreationRequestMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._subscriptionFeeFunc);
         param1.addChild(this._jackpotFunc);
         param1.addChild(this._maxCountWinnersFunc);
         param1.addChild(this._delayBeforeStartFunc);
         param1.addChild(this._durationFunc);
         this._criterionstree = param1.addChild(this._criterionstreeFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.isPrivate = BooleanByteWrapper.getFlag(_loc2_,0);
         this.isForGuild = BooleanByteWrapper.getFlag(_loc2_,1);
         this.isForAlliance = BooleanByteWrapper.getFlag(_loc2_,2);
         this.needNotifications = BooleanByteWrapper.getFlag(_loc2_,3);
    }

    private void _subscriptionFeeFunc(ICustomDataInput param1) {
         this.subscriptionFee = param1.readVarUhLong();
         if(this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.subscriptionFee + ") on element of DareCreationRequestMessage.subscriptionFee.");
    }

    private void _jackpotFunc(ICustomDataInput param1) {
         this.jackpot = param1.readVarUhLong();
         if(this.jackpot < 0 || this.jackpot > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.jackpot + ") on element of DareCreationRequestMessage.jackpot.");
    }

    private void _maxCountWinnersFunc(ICustomDataInput param1) {
         this.maxCountWinners = param1.readUnsignedShort();
         if(this.maxCountWinners < 0 || this.maxCountWinners > 65535)
            throw new Exception("Forbidden value (" + this.maxCountWinners + ") on element of DareCreationRequestMessage.maxCountWinners.");
    }

    private void _delayBeforeStartFunc(ICustomDataInput param1) {
         this.delayBeforeStart = param1.readUnsignedInt();
         if(this.delayBeforeStart < 0 || this.delayBeforeStart > 4.294967295E9)
            throw new Exception("Forbidden value (" + this.delayBeforeStart + ") on element of DareCreationRequestMessage.delayBeforeStart.");
    }

    private void _durationFunc(ICustomDataInput param1) {
         this.duration = param1.readUnsignedInt();
         if(this.duration < 0 || this.duration > 4.294967295E9)
            throw new Exception("Forbidden value (" + this.duration + ") on element of DareCreationRequestMessage.duration.");
    }

    private void _criterionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._criterionstree.addChild(this._criterionsFunc);
            _loc3_++;
    }

    private void _criterionsFunc(ICustomDataInput param1) {
         DareCriteria _loc2_ = new DareCriteria();
         _loc2_.deserialize(param1);
         this.criterions.push(_loc2_);
    }

}