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

public class HouseInformationsForGuild extends HouseInformations implements INetworkType {

    private int protocolId = 170;
    private int instanceId = 0;
    private boolean secondHand = false;
    private String ownerName = "";
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;
    private Vector<int> skillListIds;
    private int guildshareParams = 0;
    private FuncTree _skillListIdstree;


    public int getTypeId() {
         return 170;
    }

    public HouseInformationsForGuild initHouseInformationsForGuild(int param1,int  param2,int  param3,boolean  param4,String  param5,int  param6,int  param7,int  param8,int  param9,Vector<int>  param10,int  param11) {
         super.initHouseInformations(param1,param2);
         this.instanceId = param3;
         this.secondHand = param4;
         this.ownerName = param5;
         this.worldX = param6;
         this.worldY = param7;
         this.mapId = param8;
         this.subAreaId = param9;
         this.skillListIds = param10;
         this.guildshareParams = param11;
         return this;
    }

    public void reset() {
         super.reset();
         this.instanceId = 0;
         this.secondHand = false;
         this.ownerName = "";
         this.worldX = 0;
         this.worldY = 0;
         this.mapId = 0;
         this.subAreaId = 0;
         this.skillListIds = new Vector.<int>();
         this.guildshareParams = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HouseInformationsForGuild(param1);
    }

    public void serializeAs_HouseInformationsForGuild(ICustomDataOutput param1) {
         super.serializeAs_HouseInformations(param1);
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         param1.writeBoolean(this.secondHand);
         param1.writeUTF(this.ownerName);
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
         param1.writeInt(this.mapId);
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         param1.writeShort(this.skillListIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.skillListIds.length)
         {
            param1.writeInt(this.skillListIds[_loc2_]);
            _loc2_++;
         }
         if(this.guildshareParams < 0)
         {
            throw new Exception("Forbidden value (" + this.guildshareParams + ") on element guildshareParams.");
         }
         param1.writeVarInt(this.guildshareParams);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseInformationsForGuild(param1);
    }

    public void deserializeAs_HouseInformationsForGuild(ICustomDataInput param1) {
         * _loc4_ = 0;
         super.deserialize(param1);
         this._instanceIdFunc(param1);
         this._secondHandFunc(param1);
         this._ownerNameFunc(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            this.skillListIds.push(_loc4_);
            _loc3_++;
         }
         this._guildshareParamsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseInformationsForGuild(param1);
    }

    public void deserializeAsyncAs_HouseInformationsForGuild(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._secondHandFunc);
         param1.addChild(this._ownerNameFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._subAreaIdFunc);
         this._skillListIdstree = param1.addChild(this._skillListIdstreeFunc);
         param1.addChild(this._guildshareParamsFunc);
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseInformationsForGuild.instanceId.");
         }
    }

    private void _secondHandFunc(ICustomDataInput param1) {
         this.secondHand = param1.readBoolean();
    }

    private void _ownerNameFunc(ICustomDataInput param1) {
         this.ownerName = param1.readUTF();
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of HouseInformationsForGuild.worldX.");
         }
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of HouseInformationsForGuild.worldY.");
         }
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of HouseInformationsForGuild.subAreaId.");
         }
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

    private void _guildshareParamsFunc(ICustomDataInput param1) {
         this.guildshareParams = param1.readVarUhInt();
         if(this.guildshareParams < 0)
         {
            throw new Exception("Forbidden value (" + this.guildshareParams + ") on element of HouseInformationsForGuild.guildshareParams.");
         }
    }

}