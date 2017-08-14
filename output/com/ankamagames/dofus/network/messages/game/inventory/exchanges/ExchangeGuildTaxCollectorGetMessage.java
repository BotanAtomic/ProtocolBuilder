package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemGenericQuantity;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeGuildTaxCollectorGetMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String collectorName = "";
  public int worldX = 0;
  public int worldY = 0;
  public int mapId = 0;
  public int subAreaId = 0;
  public String userName = "";
  public Number callerId = 0;
  public String callerName = "";
  public Number experience = 0;
  public int pods = 0;
  public Vector<ObjectItemGenericQuantity> objectsInfos;
  private FuncTree _objectsInfostree;
  public static final int protocolId = 5762;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.collectorName);
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
    param1.writeUTF(this.userName);
    if (this.callerId < 0 || this.callerId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.callerId + ") on element callerId.");
    }
    param1.writeVarLong(this.callerId);
    param1.writeUTF(this.callerName);
    if (this.experience < -9.007199254740992E15 || this.experience > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
    }
    param1.writeDouble(this.experience);
    if (this.pods < 0) {
      throw new Exception("Forbidden value (" + this.pods + ") on element pods.");
    }
    param1.writeVarShort(this.pods);
    param1.writeShort(this.objectsInfos.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objectsInfos.length) {
      ((ObjectItemGenericQuantity) this.objectsInfos[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    ObjectItemGenericQuantity _loc4_ = null;
    this.collectorName = param1.readUTF();

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

    this.userName = param1.readUTF();

    this.callerId = param1.readVarUhLong();
    if (this.callerId < 0 || this.callerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.callerId
              + ") on element of ExchangeGuildTaxCollectorGetMessage.callerId.");
    }

    this.callerName = param1.readUTF();

    this.experience = param1.readVarUhLong();
    if (this.experience < 0 || this.experience > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.experience + ") on element of MountClientData.experience.");
    }

    this.pods = param1.readVarUhInt();
    if (this.pods < 0) {
      throw new Exception(
          "Forbidden value (" + this.pods + ") on element of TaxCollectorLootInformations.pods.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new ObjectItemGenericQuantity();
      _loc4_.deserialize(param1);
      this.objectsInfos.push(_loc4_);
      _loc3_++;
    }
  }
}
