package com.ankamagames.dofus.network.types.connection;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameServerInformations extends Object implements INetworkType {

  public int id = 0;
  public int type = -1;
  public int status = 1;
  public int completion = 0;
  public boolean isSelectable = false;
  public int charactersCount = 0;
  public int charactersSlots = 0;
  public Number date = 0;
  public static final int protocolId = 25;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);
    param1.writeByte(this.type);
    param1.writeByte(this.status);
    param1.writeByte(this.completion);
    param1.writeBoolean(this.isSelectable);
    if (this.charactersCount < 0) {
      throw new Error("Forbidden value (" + this.charactersCount + ") on element charactersCount.");
    }
    param1.writeByte(this.charactersCount);
    if (this.charactersSlots < 0) {
      throw new Error("Forbidden value (" + this.charactersSlots + ") on element charactersSlots.");
    }
    param1.writeByte(this.charactersSlots);
    if (this.date < -9.007199254740992E15 || this.date > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.date + ") on element date.");
    }
    param1.writeDouble(this.date);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.type = param1.readByte();
    if (this.type < 0) {
      throw new Error("Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }

    this.status = param1.readByte();
    if (this.status < 0) {
      throw new Error(
          "Forbidden value (" + this.status + ") on element of GameServerInformations.status.");
    }

    this.completion = param1.readByte();
    if (this.completion < 0) {
      throw new Error(
          "Forbidden value ("
              + this.completion
              + ") on element of GameServerInformations.completion.");
    }

    this.isSelectable = param1.readBoolean();

    this.charactersCount = param1.readByte();
    if (this.charactersCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.charactersCount
              + ") on element of GameServerInformations.charactersCount.");
    }

    this.charactersSlots = param1.readByte();
    if (this.charactersSlots < 0) {
      throw new Error(
          "Forbidden value ("
              + this.charactersSlots
              + ") on element of GameServerInformations.charactersSlots.");
    }

    this.date = param1.readInt();
    if (this.date < 0) {
      throw new Error(
          "Forbidden value ("
              + this.date
              + ") on element of AdditionalTaxCollectorInformations.date.");
    }
  }
}
