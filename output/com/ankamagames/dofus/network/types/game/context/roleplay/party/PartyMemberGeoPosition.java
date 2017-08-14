package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyMemberGeoPosition extends Object implements INetworkType {

  public int memberId = 0;
  public int worldX = 0;
  public int worldY = 0;
  public int mapId = 0;
  public int subAreaId = 0;
  public static final int protocolId = 378;

  public void serialize(ICustomDataOutput param1) {
    if (this.memberId < 0) {
      throw new Error("Forbidden value (" + this.memberId + ") on element memberId.");
    }
    param1.writeInt(this.memberId);
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Error("Forbidden value (" + this.worldX + ") on element worldX.");
    }
    param1.writeShort(this.worldX);
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Error("Forbidden value (" + this.worldY + ") on element worldY.");
    }
    param1.writeShort(this.worldY);
    param1.writeInt(this.mapId);
    if (this.subAreaId < 0) {
      throw new Error("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }
    param1.writeVarShort(this.subAreaId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.memberId = param1.readInt();
    if (this.memberId < 0) {
      throw new Error(
          "Forbidden value (" + this.memberId + ") on element of PartyMemberGeoPosition.memberId.");
    }

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

    this.subAreaId = param1.readVarUhShort();
    if (this.subAreaId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.subAreaId
              + ") on element of PrismSubareaEmptyInfo.subAreaId.");
    }
  }
}
