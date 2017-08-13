package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class TreasureHuntDigRequestAnswerFailedMessage extends TreasureHuntDigRequestAnswerMessage implements INetworkMessage {

    private int protocolId = 6509;
    private boolean _isInitialized = false;
    private int wrongFlagCount = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6509;
    }

    public TreasureHuntDigRequestAnswerFailedMessage initTreasureHuntDigRequestAnswerFailedMessage(int param1,int  param2,int  param3) {
         super.initTreasureHuntDigRequestAnswerMessage(param1,param2);
         this.wrongFlagCount = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.wrongFlagCount = 0;
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
         this.serializeAs_TreasureHuntDigRequestAnswerFailedMessage(param1);
    }

    public void serializeAs_TreasureHuntDigRequestAnswerFailedMessage(ICustomDataOutput param1) {
         super.serializeAs_TreasureHuntDigRequestAnswerMessage(param1);
         if(this.wrongFlagCount < 0)
         {
            throw new Exception("Forbidden value (" + this.wrongFlagCount + ") on element wrongFlagCount.");
         }
         param1.writeByte(this.wrongFlagCount);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TreasureHuntDigRequestAnswerFailedMessage(param1);
    }

    public void deserializeAs_TreasureHuntDigRequestAnswerFailedMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._wrongFlagCountFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TreasureHuntDigRequestAnswerFailedMessage(param1);
    }

    public void deserializeAsyncAs_TreasureHuntDigRequestAnswerFailedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._wrongFlagCountFunc);
    }

    private void _wrongFlagCountFunc(ICustomDataInput param1) {
         this.wrongFlagCount = param1.readByte();
         if(this.wrongFlagCount < 0)
         {
            throw new Exception("Forbidden value (" + this.wrongFlagCount + ") on element of TreasureHuntDigRequestAnswerFailedMessage.wrongFlagCount.");
         }
    }

}