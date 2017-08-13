package package com.ankamagames.dofus.network.messages.game.context.roleplay.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class StatsUpgradeRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5610;
    private boolean _isInitialized = false;
    private boolean useAdditionnal = false;
    private int statId = 11;
    private int boostPoint = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5610;
    }

    public StatsUpgradeRequestMessage initStatsUpgradeRequestMessage(boolean param1,int  param2,int  param3) {
         this.useAdditionnal = param1;
         this.statId = param2;
         this.boostPoint = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.useAdditionnal = false;
         this.statId = 11;
         this.boostPoint = 0;
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
         this.serializeAs_StatsUpgradeRequestMessage(param1);
    }

    public void serializeAs_StatsUpgradeRequestMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.useAdditionnal);
         param1.writeByte(this.statId);
         if(this.boostPoint < 0)
            throw new Exception("Forbidden value (" + this.boostPoint + ") on element boostPoint.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StatsUpgradeRequestMessage(param1);
    }

    public void deserializeAs_StatsUpgradeRequestMessage(ICustomDataInput param1) {
         this._useAdditionnalFunc(param1);
         this._statIdFunc(param1);
         this._boostPointFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StatsUpgradeRequestMessage(param1);
    }

    public void deserializeAsyncAs_StatsUpgradeRequestMessage(FuncTree param1) {
         param1.addChild(this._useAdditionnalFunc);
         param1.addChild(this._statIdFunc);
         param1.addChild(this._boostPointFunc);
    }

    private void _useAdditionnalFunc(ICustomDataInput param1) {
         this.useAdditionnal = param1.readBoolean();
    }

    private void _statIdFunc(ICustomDataInput param1) {
         this.statId = param1.readByte();
         if(this.statId < 0)
            throw new Exception("Forbidden value (" + this.statId + ") on element of StatsUpgradeRequestMessage.statId.");
    }

    private void _boostPointFunc(ICustomDataInput param1) {
         this.boostPoint = param1.readVarUhShort();
         if(this.boostPoint < 0)
            throw new Exception("Forbidden value (" + this.boostPoint + ") on element of StatsUpgradeRequestMessage.boostPoint.");
    }

}