package package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TreasureHuntFlagRemoveRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6510;
    private boolean _isInitialized = false;
    private int questType = 0;
    private int index = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6510;
    }

    public TreasureHuntFlagRemoveRequestMessage initTreasureHuntFlagRemoveRequestMessage(int param1,int  param2) {
         this.questType = param1;
         this.index = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.questType = 0;
         this.index = 0;
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
         this.serializeAs_TreasureHuntFlagRemoveRequestMessage(param1);
    }

    public void serializeAs_TreasureHuntFlagRemoveRequestMessage(ICustomDataOutput param1) {
         param1.writeByte(this.questType);
         if(this.index < 0)
            throw new Exception("Forbidden value (" + this.index + ") on element index.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TreasureHuntFlagRemoveRequestMessage(param1);
    }

    public void deserializeAs_TreasureHuntFlagRemoveRequestMessage(ICustomDataInput param1) {
         this._questTypeFunc(param1);
         this._indexFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TreasureHuntFlagRemoveRequestMessage(param1);
    }

    public void deserializeAsyncAs_TreasureHuntFlagRemoveRequestMessage(FuncTree param1) {
         param1.addChild(this._questTypeFunc);
         param1.addChild(this._indexFunc);
    }

    private void _questTypeFunc(ICustomDataInput param1) {
         this.questType = param1.readByte();
         if(this.questType < 0)
            throw new Exception("Forbidden value (" + this.questType + ") on element of TreasureHuntFlagRemoveRequestMessage.questType.");
    }

    private void _indexFunc(ICustomDataInput param1) {
         this.index = param1.readByte();
         if(this.index < 0)
            throw new Exception("Forbidden value (" + this.index + ") on element of TreasureHuntFlagRemoveRequestMessage.index.");
    }

}