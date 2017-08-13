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
import java.lang.Exception;

public class HouseGuildShareRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5704;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int instanceId = 0;
    private boolean enable = false;
    private int rights = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5704;
    }

    public HouseGuildShareRequestMessage initHouseGuildShareRequestMessage(int param1,int  param2,boolean  param3,int  param4) {
         this.houseId = param1;
         this.instanceId = param2;
         this.enable = param3;
         this.rights = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.houseId = 0;
         this.instanceId = 0;
         this.enable = false;
         this.rights = 0;
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
         this.serializeAs_HouseGuildShareRequestMessage(param1);
    }

    public void serializeAs_HouseGuildShareRequestMessage(ICustomDataOutput param1) {
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseGuildShareRequestMessage(param1);
    }

    public void deserializeAs_HouseGuildShareRequestMessage(ICustomDataInput param1) {
         this._houseIdFunc(param1);
         this._instanceIdFunc(param1);
         this._enableFunc(param1);
         this._rightsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseGuildShareRequestMessage(param1);
    }

    public void deserializeAsyncAs_HouseGuildShareRequestMessage(FuncTree param1) {
         param1.addChild(this._houseIdFunc);
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._enableFunc);
         param1.addChild(this._rightsFunc);
    }

    private void _houseIdFunc(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseGuildShareRequestMessage.houseId.");
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseGuildShareRequestMessage.instanceId.");
    }

    private void _enableFunc(ICustomDataInput param1) {
         this.enable = param1.readBoolean();
    }

    private void _rightsFunc(ICustomDataInput param1) {
         this.rights = param1.readVarUhInt();
         if(this.rights < 0)
            throw new Exception("Forbidden value (" + this.rights + ") on element of HouseGuildShareRequestMessage.rights.");
    }

}