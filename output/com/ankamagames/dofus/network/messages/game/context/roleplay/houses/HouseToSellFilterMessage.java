package package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

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
import java.lang.Exception;

public class HouseToSellFilterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6137;
    private boolean _isInitialized = false;
    private int areaId = 0;
    private int atLeastNbRoom = 0;
    private int atLeastNbChest = 0;
    private int skillRequested = 0;
    private Number maxPrice = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6137;
    }

    public HouseToSellFilterMessage initHouseToSellFilterMessage(int param1,int  param2,int  param3,int  param4,Number  param5) {
         this.areaId = param1;
         this.atLeastNbRoom = param2;
         this.atLeastNbChest = param3;
         this.skillRequested = param4;
         this.maxPrice = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.areaId = 0;
         this.atLeastNbRoom = 0;
         this.atLeastNbChest = 0;
         this.skillRequested = 0;
         this.maxPrice = 0;
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
         this.serializeAs_HouseToSellFilterMessage(param1);
    }

    public void serializeAs_HouseToSellFilterMessage(ICustomDataOutput param1) {
         param1.writeInt(this.areaId);
         if(this.atLeastNbRoom < 0)
            throw new Exception("Forbidden value (" + this.atLeastNbRoom + ") on element atLeastNbRoom.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseToSellFilterMessage(param1);
    }

    public void deserializeAs_HouseToSellFilterMessage(ICustomDataInput param1) {
         this._areaIdFunc(param1);
         this._atLeastNbRoomFunc(param1);
         this._atLeastNbChestFunc(param1);
         this._skillRequestedFunc(param1);
         this._maxPriceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseToSellFilterMessage(param1);
    }

    public void deserializeAsyncAs_HouseToSellFilterMessage(FuncTree param1) {
         param1.addChild(this._areaIdFunc);
         param1.addChild(this._atLeastNbRoomFunc);
         param1.addChild(this._atLeastNbChestFunc);
         param1.addChild(this._skillRequestedFunc);
         param1.addChild(this._maxPriceFunc);
    }

    private void _areaIdFunc(ICustomDataInput param1) {
         this.areaId = param1.readInt();
    }

    private void _atLeastNbRoomFunc(ICustomDataInput param1) {
         this.atLeastNbRoom = param1.readByte();
         if(this.atLeastNbRoom < 0)
            throw new Exception("Forbidden value (" + this.atLeastNbRoom + ") on element of HouseToSellFilterMessage.atLeastNbRoom.");
    }

    private void _atLeastNbChestFunc(ICustomDataInput param1) {
         this.atLeastNbChest = param1.readByte();
         if(this.atLeastNbChest < 0)
            throw new Exception("Forbidden value (" + this.atLeastNbChest + ") on element of HouseToSellFilterMessage.atLeastNbChest.");
    }

    private void _skillRequestedFunc(ICustomDataInput param1) {
         this.skillRequested = param1.readVarUhShort();
         if(this.skillRequested < 0)
            throw new Exception("Forbidden value (" + this.skillRequested + ") on element of HouseToSellFilterMessage.skillRequested.");
    }

    private void _maxPriceFunc(ICustomDataInput param1) {
         this.maxPrice = param1.readVarUhLong();
         if(this.maxPrice < 0 || this.maxPrice > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.maxPrice + ") on element of HouseToSellFilterMessage.maxPrice.");
    }

}