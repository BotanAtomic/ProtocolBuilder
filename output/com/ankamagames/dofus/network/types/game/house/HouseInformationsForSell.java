package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HouseInformationsForSell extends Object implements INetworkType {

    private int protocolId = 221;
    private int instanceId = 0;
    private boolean secondHand = false;
    private int modelId = 0;
    private String ownerName = "";
    private boolean ownerConnected = false;
    private int worldX = 0;
    private int worldY = 0;
    private int subAreaId = 0;
    private int nbRoom = 0;
    private int nbChest = 0;
    private Vector<int> skillListIds;
    private boolean isLocked = false;
    private Number price = 0;
    private FuncTree _skillListIdstree;


    public int getTypeId() {
         return 221;
    }

    public HouseInformationsForSell initHouseInformationsForSell(int param1,boolean  param2,int  param3,String  param4,boolean  param5,int  param6,int  param7,int  param8,int  param9,int  param10,Vector<int>  param11,boolean  param12,Number  param13) {
         this.instanceId = param1;
         this.secondHand = param2;
         this.modelId = param3;
         this.ownerName = param4;
         this.ownerConnected = param5;
         this.worldX = param6;
         this.worldY = param7;
         this.subAreaId = param8;
         this.nbRoom = param9;
         this.nbChest = param10;
         this.skillListIds = param11;
         this.isLocked = param12;
         this.price = param13;
         return this;
    }

    public void reset() {
         this.instanceId = 0;
         this.secondHand = false;
         this.modelId = 0;
         this.ownerName = "";
         this.ownerConnected = false;
         this.worldX = 0;
         this.worldY = 0;
         this.subAreaId = 0;
         this.nbRoom = 0;
         this.nbChest = 0;
         this.skillListIds = new Vector.<int>();
         this.isLocked = false;
         this.price = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HouseInformationsForSell(param1);
    }

    public void serializeAs_HouseInformationsForSell(ICustomDataOutput param1) {
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         param1.writeBoolean(this.secondHand);
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element modelId.");
         }
         param1.writeVarInt(this.modelId);
         param1.writeUTF(this.ownerName);
         param1.writeBoolean(this.ownerConnected);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         param1.writeByte(this.nbRoom);
         param1.writeByte(this.nbChest);
         param1.writeShort(this.skillListIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.skillListIds.length)
         {
            param1.writeInt(this.skillListIds[_loc2_]);
            _loc2_++;
         }
         param1.writeBoolean(this.isLocked);
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseInformationsForSell(param1);
    }

    public void deserializeAs_HouseInformationsForSell(ICustomDataInput param1) {
         * _loc4_ = 0;
         this._instanceIdFunc(param1);
         this._secondHandFunc(param1);
         this._modelIdFunc(param1);
         this._ownerNameFunc(param1);
         this._ownerConnectedFunc(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._subAreaIdFunc(param1);
         this._nbRoomFunc(param1);
         this._nbChestFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            this.skillListIds.push(_loc4_);
            _loc3_++;
         }
         this._isLockedFunc(param1);
         this._priceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseInformationsForSell(param1);
    }

    public void deserializeAsyncAs_HouseInformationsForSell(FuncTree param1) {
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._secondHandFunc);
         param1.addChild(this._modelIdFunc);
         param1.addChild(this._ownerNameFunc);
         param1.addChild(this._ownerConnectedFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._nbRoomFunc);
         param1.addChild(this._nbChestFunc);
         this._skillListIdstree = param1.addChild(this._skillListIdstreeFunc);
         param1.addChild(this._isLockedFunc);
         param1.addChild(this._priceFunc);
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseInformationsForSell.instanceId.");
         }
    }

    private void _secondHandFunc(ICustomDataInput param1) {
         this.secondHand = param1.readBoolean();
    }

    private void _modelIdFunc(ICustomDataInput param1) {
         this.modelId = param1.readVarUhInt();
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element of HouseInformationsForSell.modelId.");
         }
    }

    private void _ownerNameFunc(ICustomDataInput param1) {
         this.ownerName = param1.readUTF();
    }

    private void _ownerConnectedFunc(ICustomDataInput param1) {
         this.ownerConnected = param1.readBoolean();
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of HouseInformationsForSell.worldX.");
         }
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of HouseInformationsForSell.worldY.");
         }
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of HouseInformationsForSell.subAreaId.");
         }
    }

    private void _nbRoomFunc(ICustomDataInput param1) {
         this.nbRoom = param1.readByte();
    }

    private void _nbChestFunc(ICustomDataInput param1) {
         this.nbChest = param1.readByte();
    }

    private void _skillListIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._skillListIdstree.addChild(this._skillListIdsFunc);
            _loc3_++;
         }
    }

    private void _skillListIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.skillListIds.push(_loc2_);
    }

    private void _isLockedFunc(ICustomDataInput param1) {
         this.isLocked = param1.readBoolean();
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element of HouseInformationsForSell.price.");
         }
    }

}