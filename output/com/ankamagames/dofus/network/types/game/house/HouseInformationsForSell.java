package com.ankamagames.dofus.network.types.game.house;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseInformationsForSell extends Object implements INetworkType {

  public int instanceId = 0;
  public boolean secondHand = false;
  public int modelId = 0;
  public String ownerName = "";
  public boolean ownerConnected = false;
  public int worldX = 0;
  public int worldY = 0;
  public int subAreaId = 0;
  public int nbRoom = 0;
  public int nbChest = 0;
  public Vector<Integer> skillListIds;
  public boolean isLocked = false;
  public Number price = 0;
  private FuncTree _skillListIdstree;
  public static final int protocolId = 221;

  public void serialize(ICustomDataOutput param1) {
    if (this.instanceId < 0) {
      throw new Error("Forbidden value (" + this.instanceId + ") on element instanceId.");
    }
    param1.writeInt(this.instanceId);
    param1.writeBoolean(this.secondHand);
    if (this.modelId < 0) {
      throw new Error("Forbidden value (" + this.modelId + ") on element modelId.");
    }
    param1.writeVarInt(this.modelId);
    param1.writeUTF(this.ownerName);
    param1.writeBoolean(this.ownerConnected);
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Error("Forbidden value (" + this.worldX + ") on element worldX.");
    }
    param1.writeShort(this.worldX);
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Error("Forbidden value (" + this.worldY + ") on element worldY.");
    }
    param1.writeShort(this.worldY);
    if (this.subAreaId < 0) {
      throw new Error("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }
    param1.writeVarShort(this.subAreaId);
    param1.writeByte(this.nbRoom);
    param1.writeByte(this.nbChest);
    param1.writeShort(this.skillListIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.skillListIds.length) {
      param1.writeInt(this.skillListIds[_loc2_]);
      _loc2_++;
    }
    param1.writeBoolean(this.isLocked);
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.price + ") on element price.");
    }
    param1.writeVarLong(this.price);
  }

  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    this.instanceId = param1.readInt();
    if (this.instanceId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.instanceId
              + ") on element of HouseInstanceInformations.instanceId.");
    }

    this.secondHand = param1.readBoolean();

    this.modelId = param1.readVarUhShort();
    if (this.modelId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.modelId
              + ") on element of MountInformationsForPaddock.modelId.");
    }

    this.ownerName = param1.readUTF();

    this.ownerConnected = param1.readBoolean();

    this.worldX = param1.readShort();
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Error(
          "Forbidden value ("
              + this.worldX
              + ") on element of PrismGeolocalizedInformation.worldX.");
    }

    this.worldY = param1.readShort();
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Error(
          "Forbidden value ("
              + this.worldY
              + ") on element of PrismGeolocalizedInformation.worldY.");
    }

    this.subAreaId = param1.readVarUhShort();
    if (this.subAreaId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.subAreaId
              + ") on element of PrismSubareaEmptyInfo.subAreaId.");
    }

    this.nbRoom = param1.readByte();

    this.nbChest = param1.readByte();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readInt();
      this.skillListIds.push(_loc4_);
      _loc3_++;
    }
    this.isLocked = param1.readBoolean();

    this.price = param1.readVarUhLong();
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.price + ") on element of PaddockInformationsForSell.price.");
    }
  }
}
