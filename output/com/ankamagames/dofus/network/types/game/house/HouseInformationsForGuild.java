package com.ankamagames.dofus.network.types.game.house;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseInformationsForGuild extends HouseInformations implements INetworkType {

  public int instanceId = 0;
  public boolean secondHand = false;
  public String ownerName = "";
  public int worldX = 0;
  public int worldY = 0;
  public int mapId = 0;
  public int subAreaId = 0;
  public Vector<Integer> skillListIds;
  public int guildshareParams = 0;
  private FuncTree _skillListIdstree;
  public static final int protocolId = 170;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.houseId < 0) {
      throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
    }
    param1.writeVarInt(this.houseId);
    if (this.modelId < 0) {
      throw new Exception("Forbidden value (" + this.modelId + ") on element modelId.");
    }
    param1.writeVarShort(this.modelId);

    if (this.instanceId < 0) {
      throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
    }
    param1.writeInt(this.instanceId);
    param1.writeBoolean(this.secondHand);
    param1.writeUTF(this.ownerName);
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
    }
    param1.writeShort(this.worldX);
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
    }
    param1.writeShort(this.worldY);
    param1.writeInt(this.mapId);
    if (this.subAreaId < 0) {
      throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }
    param1.writeVarShort(this.subAreaId);
    param1.writeShort(this.skillListIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.skillListIds.length) {
      param1.writeInt(this.skillListIds[_loc2_]);
      _loc2_++;
    }
    if (this.guildshareParams < 0) {
      throw new Exception(
          "Forbidden value (" + this.guildshareParams + ") on element guildshareParams.");
    }
    param1.writeVarInt(this.guildshareParams);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.instanceId = param1.readInt();
    if (this.instanceId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.instanceId
              + ") on element of HouseInstanceInformations.instanceId.");
    }

    this.secondHand = param1.readBoolean();

    this.ownerName = param1.readUTF();

    this.worldX = param1.readShort();
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.worldX
              + ") on element of PrismGeolocalizedInformation.worldX.");
    }

    this.worldY = param1.readShort();
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.worldY
              + ") on element of PrismGeolocalizedInformation.worldY.");
    }

    this.mapId = param1.readInt();

    this.subAreaId = param1.readVarUhShort();
    if (this.subAreaId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.subAreaId
              + ") on element of PrismSubareaEmptyInfo.subAreaId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readInt();
      this.skillListIds.push(_loc4_);
      _loc3_++;
    }
    this.guildshareParams = param1.readVarUhInt();
    if (this.guildshareParams < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.guildshareParams
              + ") on element of HouseInformationsForGuild.guildshareParams.");
    }
  }
}
