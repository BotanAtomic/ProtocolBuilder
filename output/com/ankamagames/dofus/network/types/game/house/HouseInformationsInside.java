package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseInformationsInside extends HouseInformations implements INetworkType {

    private int protocolId = 218;
    private HouseInstanceInformations houseInfos;
    private int worldX = 0;
    private int worldY = 0;
    private FuncTree _houseInfostree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.houseInfos.getTypeId());
         this.houseInfos.serialize(param1);
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
         param1.writeShort(this.houseInfos.getTypeId());
         this.houseInfos.serialize(param1);
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
         super.serializeAs_HouseInformations(param1);
         param1.writeShort(this.houseInfos.getTypeId());
         this.houseInfos.serialize(param1);
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
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of AccountHouseInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of AccountHouseInformations.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of AccountHouseInformations.subAreaId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of AccountHouseInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of AccountHouseInformations.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of AccountHouseInformations.subAreaId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of AccountHouseInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of AccountHouseInformations.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of AccountHouseInformations.subAreaId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of HouseInformationsInside.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of HouseInformationsInside.worldY.");
         }
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of AccountHouseInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of AccountHouseInformations.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of AccountHouseInformations.subAreaId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of AccountHouseInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of AccountHouseInformations.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of AccountHouseInformations.subAreaId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of AccountHouseInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of AccountHouseInformations.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of AccountHouseInformations.subAreaId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of HouseInformationsInside.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of HouseInformationsInside.worldY.");
         }
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
    }

}