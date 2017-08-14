package com.ankamagames.dofus.network.types.game.data.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectItemNotInContainer extends Item implements INetworkType {

  public int objectGID = 0;
  public Vector<ObjectEffect> effects;
  public int objectUID = 0;
  public int quantity = 0;
  private FuncTree _effectstree;
  public static final int protocolId = 134;

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
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    ObjectEffect _loc5_ = null;
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

    this.objectGID = param1.readVarUhShort();
    if (this.objectGID < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.objectGID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectGID.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(ObjectEffect, _loc4_);
      _loc5_.deserialize(param1);
      this.effects.push(_loc5_);
      _loc3_++;
    }
    this.objectUID = param1.readVarUhInt();
    if (this.objectUID < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.objectUID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectUID.");
    }

    this.quantity = param1.readVarUhInt();
    if (this.quantity < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.quantity
              + ") on element of ObjectItemToSellInHumanVendorShop.quantity.");
    }
  }
}
