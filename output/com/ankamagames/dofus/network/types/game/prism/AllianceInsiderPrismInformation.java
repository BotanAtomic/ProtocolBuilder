package com.ankamagames.dofus.network.types.game.prism;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceInsiderPrismInformation extends PrismInformation implements INetworkType {

  public int lastTimeSlotModificationDate = 0;
  public int lastTimeSlotModificationAuthorGuildId = 0;
  public Number lastTimeSlotModificationAuthorId = 0;
  public String lastTimeSlotModificationAuthorName = "";
  public Vector<ObjectItem> modulesObjects;
  private FuncTree _modulesObjectstree;
  public static final int protocolId = 431;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.typeId < 0) {
      throw new Error("Forbidden value (" + this.typeId + ") on element typeId.");
    }
    param1.writeByte(this.typeId);
    param1.writeByte(this.state);
    if (this.nextVulnerabilityDate < 0) {
      throw new Error(
          "Forbidden value (" + this.nextVulnerabilityDate + ") on element nextVulnerabilityDate.");
    }
    param1.writeInt(this.nextVulnerabilityDate);
    if (this.placementDate < 0) {
      throw new Error("Forbidden value (" + this.placementDate + ") on element placementDate.");
    }
    param1.writeInt(this.placementDate);
    if (this.rewardTokenCount < 0) {
      throw new Error(
          "Forbidden value (" + this.rewardTokenCount + ") on element rewardTokenCount.");
    }
    param1.writeVarInt(this.rewardTokenCount);

    if (this.lastTimeSlotModificationDate < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lastTimeSlotModificationDate
              + ") on element lastTimeSlotModificationDate.");
    }
    param1.writeInt(this.lastTimeSlotModificationDate);
    if (this.lastTimeSlotModificationAuthorGuildId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lastTimeSlotModificationAuthorGuildId
              + ") on element lastTimeSlotModificationAuthorGuildId.");
    }
    param1.writeVarInt(this.lastTimeSlotModificationAuthorGuildId);
    if (this.lastTimeSlotModificationAuthorId < 0
        || this.lastTimeSlotModificationAuthorId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.lastTimeSlotModificationAuthorId
              + ") on element lastTimeSlotModificationAuthorId.");
    }
    param1.writeVarLong(this.lastTimeSlotModificationAuthorId);
    param1.writeUTF(this.lastTimeSlotModificationAuthorName);
    param1.writeShort(this.modulesObjects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.modulesObjects.length) {
      ((ObjectItem) this.modulesObjects[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    ObjectItem _loc4_ = null;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.lastTimeSlotModificationDate = param1.readInt();
    if (this.lastTimeSlotModificationDate < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lastTimeSlotModificationDate
              + ") on element of AllianceInsiderPrismInformation.lastTimeSlotModificationDate.");
    }

    this.lastTimeSlotModificationAuthorGuildId = param1.readVarUhInt();
    if (this.lastTimeSlotModificationAuthorGuildId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lastTimeSlotModificationAuthorGuildId
              + ") on element of AllianceInsiderPrismInformation.lastTimeSlotModificationAuthorGuildId.");
    }

    this.lastTimeSlotModificationAuthorId = param1.readVarUhLong();
    if (this.lastTimeSlotModificationAuthorId < 0
        || this.lastTimeSlotModificationAuthorId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.lastTimeSlotModificationAuthorId
              + ") on element of AllianceInsiderPrismInformation.lastTimeSlotModificationAuthorId.");
    }

    this.lastTimeSlotModificationAuthorName = param1.readUTF();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new ObjectItem();
      _loc4_.deserialize(param1);
      this.modulesObjects.push(_loc4_);
      _loc3_++;
    }
  }
}
