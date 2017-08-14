package com.ankamagames.dofus.network.types.game.data.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectItemToSellInBid extends ObjectItemToSell implements INetworkType {

  public int unsoldDelay = 0;
  public static final int protocolId = 164;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.objectGID < 0) {
      throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
    }
    param1.writeVarShort(this.objectGID);
    param1.writeShort(this.effects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.effects.length) {
      param1.writeShort(((ObjectEffect) (this.effects[_loc2_])).getTypeId());
      ((ObjectEffect) this.effects[_loc2_]).serialize(param1);
      _loc2_++;
    }
    if (this.objectUID < 0) {
      throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }
    param1.writeVarInt(this.objectUID);
    if (this.quantity < 0) {
      throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
    }
    param1.writeVarInt(this.quantity);
    if (this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.objectPrice + ") on element objectPrice.");
    }
    param1.writeVarLong(this.objectPrice);

    if (this.unsoldDelay < 0) {
      throw new Exception("Forbidden value (" + this.unsoldDelay + ") on element unsoldDelay.");
    }
    param1.writeInt(this.unsoldDelay);
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

    this.unsoldDelay = param1.readVarUhShort();
    if (this.unsoldDelay < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.unsoldDelay
              + ") on element of SellerBuyerDescriptor.unsoldDelay.");
    }
  }
}
