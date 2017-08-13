package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AchievementDetailedListRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6357;
    private boolean _isInitialized = false;
    private int categoryId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6357;
    }

    public AchievementDetailedListRequestMessage initAchievementDetailedListRequestMessage(int param1) {
         this.categoryId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.categoryId = 0;
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
         this.serializeAs_AchievementDetailedListRequestMessage(param1);
    }

    public void serializeAs_AchievementDetailedListRequestMessage(ICustomDataOutput param1) {
         if(this.categoryId < 0)
         {
            throw new Exception("Forbidden value (" + this.categoryId + ") on element categoryId.");
         }
         param1.writeVarShort(this.categoryId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AchievementDetailedListRequestMessage(param1);
    }

    public void deserializeAs_AchievementDetailedListRequestMessage(ICustomDataInput param1) {
         this._categoryIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AchievementDetailedListRequestMessage(param1);
    }

    public void deserializeAsyncAs_AchievementDetailedListRequestMessage(FuncTree param1) {
         param1.addChild(this._categoryIdFunc);
    }

    private void _categoryIdFunc(ICustomDataInput param1) {
         this.categoryId = param1.readVarUhShort();
         if(this.categoryId < 0)
         {
            throw new Exception("Forbidden value (" + this.categoryId + ") on element of AchievementDetailedListRequestMessage.categoryId.");
         }
    }

}