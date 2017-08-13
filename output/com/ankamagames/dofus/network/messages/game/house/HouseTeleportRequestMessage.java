package package com.ankamagames.dofus.network.messages.game.house;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class HouseTeleportRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6726;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int houseInstanceId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6726;
    }

    public HouseTeleportRequestMessage initHouseTeleportRequestMessage(int param1,int  param2) {
         this.houseId = param1;
         this.houseInstanceId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.houseId = 0;
         this.houseInstanceId = 0;
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
         this.serializeAs_HouseTeleportRequestMessage(param1);
    }

    public void serializeAs_HouseTeleportRequestMessage(ICustomDataOutput param1) {
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseTeleportRequestMessage(param1);
    }

    public void deserializeAs_HouseTeleportRequestMessage(ICustomDataInput param1) {
         this._houseIdFunc(param1);
         this._houseInstanceIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseTeleportRequestMessage(param1);
    }

    public void deserializeAsyncAs_HouseTeleportRequestMessage(FuncTree param1) {
         param1.addChild(this._houseIdFunc);
         param1.addChild(this._houseInstanceIdFunc);
    }

    private void _houseIdFunc(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseTeleportRequestMessage.houseId.");
    }

    private void _houseInstanceIdFunc(ICustomDataInput param1) {
         this.houseInstanceId = param1.readInt();
    }

}