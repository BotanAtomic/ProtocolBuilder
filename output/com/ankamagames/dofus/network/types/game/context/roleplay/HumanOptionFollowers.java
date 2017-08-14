package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.IndexedEntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionFollowers extends HumanOption implements INetworkType {

  public Vector<IndexedEntityLook> followingCharactersLook;
  private FuncTree _followingCharactersLooktree;
  public static final int protocolId = 410;

  @Override
  public void serialize(ICustomDataOutput param1) {

    param1.writeShort(this.followingCharactersLook.length);
    int _loc2_ = 0;
    while (_loc2_ < this.followingCharactersLook.length) {
      ((IndexedEntityLook) this.followingCharactersLook[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    IndexedEntityLook _loc4_ = null;
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

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new IndexedEntityLook();
      _loc4_.deserialize(param1);
      this.followingCharactersLook.push(_loc4_);
      _loc3_++;
    }
  }
}
