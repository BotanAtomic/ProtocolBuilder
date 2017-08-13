package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class LifePointsRegenBeginMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5684;
    private boolean _isInitialized = false;
    private int regenRate = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5684;
    }

    public LifePointsRegenBeginMessage initLifePointsRegenBeginMessage(int param1) {
         this.regenRate = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.regenRate = 0;
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
         this.serializeAs_LifePointsRegenBeginMessage(param1);
    }

    public void serializeAs_LifePointsRegenBeginMessage(ICustomDataOutput param1) {
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element regenRate.");
         }
         param1.writeByte(this.regenRate);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LifePointsRegenBeginMessage(param1);
    }

    public void deserializeAs_LifePointsRegenBeginMessage(ICustomDataInput param1) {
         this._regenRateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LifePointsRegenBeginMessage(param1);
    }

    public void deserializeAsyncAs_LifePointsRegenBeginMessage(FuncTree param1) {
         param1.addChild(this._regenRateFunc);
    }

    private void _regenRateFunc(ICustomDataInput param1) {
         this.regenRate = param1.readUnsignedByte();
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element of LifePointsRegenBeginMessage.regenRate.");
         }
    }

}