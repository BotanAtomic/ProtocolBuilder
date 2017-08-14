package com.ankamagames.dofus.network.messages.common.basic;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.common.basic.StatisticData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class BasicStatWithDataMessage extends BasicStatMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<StatisticData> datas;
  private FuncTree _datastree;
  public static final int protocolId = 6573;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.timeSpent < 0 || this.timeSpent > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.timeSpent + ") on element timeSpent.");
    }
    param1.writeDouble(this.timeSpent);
    param1.writeVarShort(this.statId);

    param1.writeShort(this.datas.length);
    int _loc2_ = 0;
    while (_loc2_ < this.datas.length) {
      param1.writeShort(((StatisticData) (this.datas[_loc2_])).getTypeId());
      ((StatisticData) this.datas[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    StatisticData _loc5_ = null;
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
      _loc5_ = ProtocolTypeManager.getInstance(StatisticData, _loc4_);
      _loc5_.deserialize(param1);
      this.datas.push(_loc5_);
      _loc3_++;
    }
  }
}
