package com.ankamagames.dofus.network.types.game.data.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectItemGenericQuantityPrice extends ObjectItemGenericQuantity
    implements INetworkType {

  public Number price = 0;
  public static final int protocolId = 494;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.objectGID < 0) {
      throw new Error("Forbidden value (" + this.objectGID + ") on element objectGID.");
    }
    param1.writeVarShort(this.objectGID);
    if (this.quantity < 0) {
      throw new Error("Forbidden value (" + this.quantity + ") on element quantity.");
    }
    param1.writeVarInt(this.quantity);

    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.price + ") on element price.");
    }
    param1.writeVarLong(this.price);
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

    this.price = param1.readVarUhLong();
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.price + ") on element of PaddockInformationsForSell.price.");
    }
  }
}
