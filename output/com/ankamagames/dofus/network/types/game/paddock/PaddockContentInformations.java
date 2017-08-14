package com.ankamagames.dofus.network.types.game.paddock;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockContentInformations extends PaddockInformations implements INetworkType {

  public int paddockId = 0;
  public int worldX = 0;
  public int worldY = 0;
  public int mapId = 0;
  public int subAreaId = 0;
  public boolean abandonned = false;
  public Vector<MountInformationsForPaddock> mountsInformations;
  private FuncTree _mountsInformationstree;
  public static final int protocolId = 183;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.maxOutdoorMount < 0) {
      throw new Exception(
          "Forbidden value (" + this.maxOutdoorMount + ") on element maxOutdoorMount.");
    }
    param1.writeVarShort(this.maxOutdoorMount);
    if (this.maxItems < 0) {
      throw new Exception("Forbidden value (" + this.maxItems + ") on element maxItems.");
    }
    param1.writeVarShort(this.maxItems);

    param1.writeInt(this.paddockId);
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
    param1.writeBoolean(this.abandonned);
    param1.writeShort(this.mountsInformations.length);
    int _loc2_ = 0;
    while (_loc2_ < this.mountsInformations.length) {
      ((MountInformationsForPaddock) this.mountsInformations[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    MountInformationsForPaddock _loc4_ = null;
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

    this.paddockId = param1.readInt();

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

    this.abandonned = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new MountInformationsForPaddock();
      _loc4_.deserialize(param1);
      this.mountsInformations.push(_loc4_);
      _loc3_++;
    }
  }
}
