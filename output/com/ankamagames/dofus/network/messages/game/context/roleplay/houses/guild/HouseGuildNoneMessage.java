package package com.ankamagames.dofus.network.messages.game.context.roleplay.houses.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HouseGuildNoneMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5701;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int instanceId = 0;
    private boolean secondHand = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5701;
    }

    public HouseGuildNoneMessage initHouseGuildNoneMessage(int param1,int  param2,boolean  param3) {
         this.houseId = param1;
         this.instanceId = param2;
         this.secondHand = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.houseId = 0;
         this.instanceId = 0;
         this.secondHand = false;
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
         this.serializeAs_HouseGuildNoneMessage(param1);
    }

    public void serializeAs_HouseGuildNoneMessage(ICustomDataOutput param1) {
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseGuildNoneMessage(param1);
    }

    public void deserializeAs_HouseGuildNoneMessage(ICustomDataInput param1) {
         this._houseIdFunc(param1);
         this._instanceIdFunc(param1);
         this._secondHandFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseGuildNoneMessage(param1);
    }

    public void deserializeAsyncAs_HouseGuildNoneMessage(FuncTree param1) {
         param1.addChild(this._houseIdFunc);
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._secondHandFunc);
    }

    private void _houseIdFunc(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseGuildNoneMessage.houseId.");
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseGuildNoneMessage.instanceId.");
    }

    private void _secondHandFunc(ICustomDataInput param1) {
         this.secondHand = param1.readBoolean();
    }

}