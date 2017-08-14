package com.ankamagames.dofus.network.types.game.data.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectItemToSellInNpcShop extends ObjectItemMinimalInformation
    implements INetworkType {

  public Number objectPrice = 0;
  public String buyCriterion = "";
  public static final int protocolId = 352;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.objectGID < 0) {
      throw new Error("Forbidden value (" + this.objectGID + ") on element objectGID.");
    }
    param1.writeVarShort(this.objectGID);
    param1.writeShort(this.effects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.effects.length) {
      param1.writeShort(((ObjectEffect) (this.effects[_loc2_])).getTypeId());
      ((ObjectEffect) this.effects[_loc2_]).serialize(param1);
      _loc2_++;
    }

    if (this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.objectPrice + ") on element objectPrice.");
    }
    param1.writeVarLong(this.objectPrice);
    param1.writeUTF(this.buyCriterion);
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

    this.objectPrice = param1.readVarUhLong();
    if (this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.objectPrice
              + ") on element of ObjectItemToSellInNpcShop.objectPrice.");
    }

    this.buyCriterion = param1.readUTF();
  }
}
