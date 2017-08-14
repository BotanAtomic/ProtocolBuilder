package com.ankamagames.dofus.network.types.game.guild.tax;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorLootInformations extends TaxCollectorComplementaryInformations
    implements INetworkType {

  public Number kamas = 0;
  public Number experience = 0;
  public int pods = 0;
  public Number itemsValue = 0;
  public static final int protocolId = 372;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
    }
    param1.writeVarLong(this.kamas);
    if (this.experience < 0 || this.experience > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
    }
    param1.writeVarLong(this.experience);
    if (this.pods < 0) {
      throw new Exception("Forbidden value (" + this.pods + ") on element pods.");
    }
    param1.writeVarInt(this.pods);
    if (this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.itemsValue + ") on element itemsValue.");
    }
    param1.writeVarLong(this.itemsValue);
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

    this.kamas = param1.readVarUhLong();
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.kamas + ") on element of TaxCollectorLootInformations.kamas.");
    }

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

    this.itemsValue = param1.readVarUhLong();
    if (this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.itemsValue
              + ") on element of TaxCollectorLootInformations.itemsValue.");
    }
  }
}
