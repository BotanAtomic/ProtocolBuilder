package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockInstancesInformations extends PaddockInformations implements INetworkType {

  public Vector<PaddockBuyableInformations> paddocks;
  private FuncTree _paddockstree;
  public static final int protocolId = 509;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.maxOutdoorMount < 0) {
      throw new Error("Forbidden value (" + this.maxOutdoorMount + ") on element maxOutdoorMount.");
    }
    param1.writeVarShort(this.maxOutdoorMount);
    if (this.maxItems < 0) {
      throw new Error("Forbidden value (" + this.maxItems + ") on element maxItems.");
    }
    param1.writeVarShort(this.maxItems);

    param1.writeShort(this.paddocks.length);
    int _loc2_ = 0;
    while (_loc2_ < this.paddocks.length) {
      param1.writeShort(((PaddockBuyableInformations) (this.paddocks[_loc2_])).getTypeId());
      ((PaddockBuyableInformations) this.paddocks[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    PaddockBuyableInformations _loc5_ = null;
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

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(PaddockBuyableInformations, _loc4_);
      _loc5_.deserialize(param1);
      this.paddocks.push(_loc5_);
      _loc3_++;
    }
  }
}
