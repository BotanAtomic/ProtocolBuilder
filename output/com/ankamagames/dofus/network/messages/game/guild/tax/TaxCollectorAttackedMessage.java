package com.ankamagames.dofus.network.messages.game.guild.tax;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorAttackedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int firstNameId = 0;
  public int lastNameId = 0;
  public int worldX = 0;
  public int worldY = 0;
  public int mapId = 0;
  public int subAreaId = 0;
  public BasicGuildInformations guild;
  private FuncTree _guildtree;
  public static final int protocolId = 5918;

  public void serialize(ICustomDataOutput param1) {
    if (this.firstNameId < 0) {
      throw new Error("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
    }
    param1.writeVarShort(this.firstNameId);
    if (this.lastNameId < 0) {
      throw new Error("Forbidden value (" + this.lastNameId + ") on element lastNameId.");
    }
    param1.writeVarShort(this.lastNameId);
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
    this.guild.serializeAs_BasicGuildInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.firstNameId = param1.readVarUhShort();
    if (this.firstNameId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.firstNameId
              + ") on element of TaxCollectorBasicInformations.firstNameId.");
    }

    this.lastNameId = param1.readVarUhShort();
    if (this.lastNameId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lastNameId
              + ") on element of TaxCollectorInformations.lastNameId.");
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

    this.guild = new BasicGuildInformations();
    this.guild.deserialize(param1);
  }
}
