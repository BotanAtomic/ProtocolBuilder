package com.ankamagames.dofus.network.types.game.startup;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemInformationWithQuantity;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StartupActionAddObject extends Object implements INetworkType {

  public int uid = 0;
  public String title = "";
  public String text = "";
  public String descUrl = "";
  public String pictureUrl = "";
  public Vector<ObjectItemInformationWithQuantity> items;
  private FuncTree _itemstree;
  public static final int protocolId = 52;

  public void serialize(ICustomDataOutput param1) {
    if (this.uid < 0) {
      throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
    }
    param1.writeInt(this.uid);
    param1.writeUTF(this.title);
    param1.writeUTF(this.text);
    param1.writeUTF(this.descUrl);
    param1.writeUTF(this.pictureUrl);
    param1.writeShort(this.items.length);
    int _loc2_ = 0;
    while (_loc2_ < this.items.length) {
      ((ObjectItemInformationWithQuantity) this.items[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    ObjectItemInformationWithQuantity _loc4_ = null;
    this.uid = param1.readUTF();

    this.title = param1.readUTF();

    this.text = param1.readUTF();

    this.descUrl = param1.readUTF();

    this.pictureUrl = param1.readUTF();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new ObjectItemInformationWithQuantity();
      _loc4_.deserialize(param1);
      this.items.push(_loc4_);
      _loc3_++;
    }
  }
}
