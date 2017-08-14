package com.ankamagames.dofus.network.types.game.prism;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismGeolocalizedInformation extends PrismSubareaEmptyInfo implements INetworkType {

  public int worldX = 0;
  public int worldY = 0;
  public int mapId = 0;
  public PrismInformation prism;
  private FuncTree _prismtree;
  public static final int protocolId = 434;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.subAreaId < 0) {
      throw new Error("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }
    param1.writeVarShort(this.subAreaId);
    if (this.allianceId < 0) {
      throw new Error("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }
    param1.writeVarInt(this.allianceId);

    if (this.worldX < -255 || this.worldX > 255) {
      throw new Error("Forbidden value (" + this.worldX + ") on element worldX.");
    }
    param1.writeShort(this.worldX);
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Error("Forbidden value (" + this.worldY + ") on element worldY.");
    }
    param1.writeShort(this.worldY);
    param1.writeInt(this.mapId);
    param1.writeShort(this.prism.getTypeId());
    this.prism.serialize(param1);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
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

    this.mapId = param1.readInt();

    int _loc2_ = param1.readUnsignedShort();
    this.prism = ProtocolTypeManager.getInstance(PrismInformation, _loc2_);
    this.prism.deserialize(param1);
  }
}
