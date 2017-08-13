package package com.ankamagames.dofus.network.messages.game.context.dungeon;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class DungeonKeyRingUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6296;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private boolean available = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6296;
    }

    public DungeonKeyRingUpdateMessage initDungeonKeyRingUpdateMessage(int param1,boolean  param2) {
         this.dungeonId = param1;
         this.available = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dungeonId = 0;
         this.available = false;
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
         this.serializeAs_DungeonKeyRingUpdateMessage(param1);
    }

    public void serializeAs_DungeonKeyRingUpdateMessage(ICustomDataOutput param1) {
         if(this.dungeonId < 0)
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DungeonKeyRingUpdateMessage(param1);
    }

    public void deserializeAs_DungeonKeyRingUpdateMessage(ICustomDataInput param1) {
         this._dungeonIdFunc(param1);
         this._availableFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DungeonKeyRingUpdateMessage(param1);
    }

    public void deserializeAsyncAs_DungeonKeyRingUpdateMessage(FuncTree param1) {
         param1.addChild(this._dungeonIdFunc);
         param1.addChild(this._availableFunc);
    }

    private void _dungeonIdFunc(ICustomDataInput param1) {
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of DungeonKeyRingUpdateMessage.dungeonId.");
    }

    private void _availableFunc(ICustomDataInput param1) {
         this.available = param1.readBoolean();
    }

}