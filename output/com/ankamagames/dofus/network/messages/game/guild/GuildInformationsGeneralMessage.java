package com.ankamagames.dofus.network.messages.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInformationsGeneralMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean abandonnedPaddock = false;
  public int level = 0;
  public Number expLevelFloor = 0;
  public Number experience = 0;
  public Number expNextLevelFloor = 0;
  public int creationDate = 0;
  public int nbTotalMembers = 0;
  public int nbConnectedMembers = 0;
  public static final int protocolId = 5557;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.abandonnedPaddock);
    if (this.level < 0 || this.level > 255) {
      throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
    if (this.expLevelFloor < 0 || this.expLevelFloor > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.expLevelFloor + ") on element expLevelFloor.");
    }
    param1.writeVarLong(this.expLevelFloor);
    if (this.experience < 0 || this.experience > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
    }
    param1.writeVarLong(this.experience);
    if (this.expNextLevelFloor < 0 || this.expNextLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.expNextLevelFloor + ") on element expNextLevelFloor.");
    }
    param1.writeVarLong(this.expNextLevelFloor);
    if (this.creationDate < 0) {
      throw new Exception("Forbidden value (" + this.creationDate + ") on element creationDate.");
    }
    param1.writeInt(this.creationDate);
    if (this.nbTotalMembers < 0) {
      throw new Exception(
          "Forbidden value (" + this.nbTotalMembers + ") on element nbTotalMembers.");
    }
    param1.writeVarShort(this.nbTotalMembers);
    if (this.nbConnectedMembers < 0) {
      throw new Exception(
          "Forbidden value (" + this.nbConnectedMembers + ") on element nbConnectedMembers.");
    }
    param1.writeVarShort(this.nbConnectedMembers);
  }

  public void deserialize(ICustomDataInput param1) {
    this.abandonnedPaddock = param1.readBoolean();

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Exception(
          "Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    this.expLevelFloor = param1.readVarUhLong();
    if (this.expLevelFloor < 0 || this.expLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.expLevelFloor
              + ") on element of GuildInformationsGeneralMessage.expLevelFloor.");
    }

    this.experience = param1.readVarUhLong();
    if (this.experience < 0 || this.experience > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.experience + ") on element of MountClientData.experience.");
    }

    this.expNextLevelFloor = param1.readVarUhLong();
    if (this.expNextLevelFloor < 0 || this.expNextLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.expNextLevelFloor
              + ") on element of GuildInformationsGeneralMessage.expNextLevelFloor.");
    }

    this.creationDate = param1.readInt();
    if (this.creationDate < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.creationDate
              + ") on element of AllianceFactSheetInformations.creationDate.");
    }

    this.nbTotalMembers = param1.readVarUhShort();
    if (this.nbTotalMembers < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.nbTotalMembers
              + ") on element of GuildInformationsGeneralMessage.nbTotalMembers.");
    }

    this.nbConnectedMembers = param1.readVarUhShort();
    if (this.nbConnectedMembers < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.nbConnectedMembers
              + ") on element of GuildInsiderFactSheetInformations.nbConnectedMembers.");
    }
  }
}
