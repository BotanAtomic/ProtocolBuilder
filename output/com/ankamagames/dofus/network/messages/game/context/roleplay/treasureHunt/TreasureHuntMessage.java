package package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt.TreasureHuntStep;
import com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt.TreasureHuntFlag;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TreasureHuntMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6486;
    private boolean _isInitialized = false;
    private int questType = 0;
    private int startMapId = 0;
    private Vector.<TreasureHuntStep> knownStepsList = ;
    private int totalStepCount = 0;
    private int checkPointCurrent = 0;
    private int checkPointTotal = 0;
    private int availableRetryCount = 0;
    private Vector.<TreasureHuntFlag> flags = ;
    private FuncTree _knownStepsListtree = ;
    private FuncTree _flagstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private TreasureHuntStep _loc7_ = null;
    private TreasureHuntFlag _loc8_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private TreasureHuntStep _loc3_ = ProtocolTypeManager.getInstance(TreasureHuntStep,_loc2_);
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6486;
    }

    public TreasureHuntMessage initTreasureHuntMessage(int param1,int  param2,Vector.<TreasureHuntStep>  param3,int  param4,int  param5,int  param6,int  param7,Vector.<TreasureHuntFlag>  param8) {
         this.questType = param1;
         this.startMapId = param2;
         this.knownStepsList = param3;
         this.totalStepCount = param4;
         this.checkPointCurrent = param5;
         this.checkPointTotal = param6;
         this.availableRetryCount = param7;
         this.flags = param8;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.questType = 0;
         this.startMapId = 0;
         this.knownStepsList = new Vector.<TreasureHuntStep>();
         this.totalStepCount = 0;
         this.checkPointCurrent = 0;
         this.checkPointTotal = 0;
         this.availableRetryCount = 0;
         this.flags = new Vector.<TreasureHuntFlag>();
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
         this.serializeAs_TreasureHuntMessage(param1);
    }

    public void serializeAs_TreasureHuntMessage(ICustomDataOutput param1) {
         param1.writeByte(this.questType);
         param1.writeInt(this.startMapId);
         param1.writeShort(this.knownStepsList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.knownStepsList.length)
            param1.writeShort((this.knownStepsList[_loc2_] as TreasureHuntStep).getTypeId());
            (this.knownStepsList[_loc2_] as TreasureHuntStep).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TreasureHuntMessage(param1);
    }

    public void deserializeAs_TreasureHuntMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         TreasureHuntStep _loc7_ = null;
         TreasureHuntFlag _loc8_ = null;
         this._questTypeFunc(param1);
         this._startMapIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(TreasureHuntStep,_loc6_);
            _loc7_.deserialize(param1);
            this.knownStepsList.push(_loc7_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TreasureHuntMessage(param1);
    }

    public void deserializeAsyncAs_TreasureHuntMessage(FuncTree param1) {
         param1.addChild(this._questTypeFunc);
         param1.addChild(this._startMapIdFunc);
         this._knownStepsListtree = param1.addChild(this._knownStepsListtreeFunc);
         param1.addChild(this._totalStepCountFunc);
         param1.addChild(this._checkPointCurrentFunc);
         param1.addChild(this._checkPointTotalFunc);
         param1.addChild(this._availableRetryCountFunc);
         this._flagstree = param1.addChild(this._flagstreeFunc);
    }

    private void _questTypeFunc(ICustomDataInput param1) {
         this.questType = param1.readByte();
         if(this.questType < 0)
            throw new Exception("Forbidden value (" + this.questType + ") on element of TreasureHuntMessage.questType.");
    }

    private void _startMapIdFunc(ICustomDataInput param1) {
         this.startMapId = param1.readInt();
    }

    private void _knownStepsListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._knownStepsListtree.addChild(this._knownStepsListFunc);
            _loc3_++;
    }

    private void _knownStepsListFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         TreasureHuntStep _loc3_ = ProtocolTypeManager.getInstance(TreasureHuntStep,_loc2_);
         _loc3_.deserialize(param1);
         this.knownStepsList.push(_loc3_);
    }

    private void _totalStepCountFunc(ICustomDataInput param1) {
         this.totalStepCount = param1.readByte();
         if(this.totalStepCount < 0)
            throw new Exception("Forbidden value (" + this.totalStepCount + ") on element of TreasureHuntMessage.totalStepCount.");
    }

    private void _checkPointCurrentFunc(ICustomDataInput param1) {
         this.checkPointCurrent = param1.readVarUhInt();
         if(this.checkPointCurrent < 0)
            throw new Exception("Forbidden value (" + this.checkPointCurrent + ") on element of TreasureHuntMessage.checkPointCurrent.");
    }

    private void _checkPointTotalFunc(ICustomDataInput param1) {
         this.checkPointTotal = param1.readVarUhInt();
         if(this.checkPointTotal < 0)
            throw new Exception("Forbidden value (" + this.checkPointTotal + ") on element of TreasureHuntMessage.checkPointTotal.");
    }

    private void _availableRetryCountFunc(ICustomDataInput param1) {
         this.availableRetryCount = param1.readInt();
    }

    private void _flagstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._flagstree.addChild(this._flagsFunc);
            _loc3_++;
    }

    private void _flagsFunc(ICustomDataInput param1) {
         TreasureHuntFlag _loc2_ = new TreasureHuntFlag();
         _loc2_.deserialize(param1);
         this.flags.push(_loc2_);
    }

}