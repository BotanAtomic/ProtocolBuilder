package com.ankamagames.dofus.network.messages.game.interactive.zaap;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ZaapListMessage extends TeleportDestinationsListMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int spawnMapId = 0;
  public static final int protocolId = 1604;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.teleporterType);
    param1.writeShort(this.mapIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.mapIds.length) {
      if (this.mapIds[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.mapIds[_loc2_]
                + ") on element 2 (starting at 1) of mapIds.");
      }
      param1.writeInt(this.mapIds[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.subAreaIds.length);
    int _loc3_ = 0;
    while (_loc3_ < this.subAreaIds.length) {
      if (this.subAreaIds[_loc3_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.subAreaIds[_loc3_]
                + ") on element 3 (starting at 1) of subAreaIds.");
      }
      param1.writeVarShort(this.subAreaIds[_loc3_]);
      _loc3_++;
    }
    param1.writeShort(this.costs.length);
    int _loc4_ = 0;
    while (_loc4_ < this.costs.length) {
      if (this.costs[_loc4_] < 0) {
        throw new Exception(
            "Forbidden value (" + this.costs[_loc4_] + ") on element 4 (starting at 1) of costs.");
      }
      param1.writeVarShort(this.costs[_loc4_]);
      _loc4_++;
    }
    param1.writeShort(this.destTeleporterType.length);
    int _loc5_ = 0;
    while (_loc5_ < this.destTeleporterType.length) {
      param1.writeByte(this.destTeleporterType[_loc5_]);
      _loc5_++;
    }

    if (this.spawnMapId < 0) {
      throw new Exception("Forbidden value (" + this.spawnMapId + ") on element spawnMapId.");
    }
    param1.writeInt(this.spawnMapId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
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

    this.spawnMapId = param1.readInt();
    if (this.spawnMapId < 0) {
      throw new Exception(
          "Forbidden value (" + this.spawnMapId + ") on element of ZaapListMessage.spawnMapId.");
    }
  }
}
