package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameDataPaddockObjectRemoveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5993;
    private boolean _isInitialized = false;
    private int cellId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5993;
    }

    public GameDataPaddockObjectRemoveMessage initGameDataPaddockObjectRemoveMessage(int param1) {
         this.cellId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.cellId = 0;
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
         this.serializeAs_GameDataPaddockObjectRemoveMessage(param1);
    }

    public void serializeAs_GameDataPaddockObjectRemoveMessage(ICustomDataOutput param1) {
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeVarShort(this.cellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameDataPaddockObjectRemoveMessage(param1);
    }

    public void deserializeAs_GameDataPaddockObjectRemoveMessage(ICustomDataInput param1) {
         this._cellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameDataPaddockObjectRemoveMessage(param1);
    }

    public void deserializeAsyncAs_GameDataPaddockObjectRemoveMessage(FuncTree param1) {
         param1.addChild(this._cellIdFunc);
    }

    private void _cellIdFunc(ICustomDataInput param1) {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of GameDataPaddockObjectRemoveMessage.cellId.");
         }
    }

}