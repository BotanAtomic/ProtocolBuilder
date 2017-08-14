package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightTackledMessage extends AbstractGameActionMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<Number> tacklersIds;
  private FuncTree _tacklersIdstree;
  public static final int protocolId = 1004;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);
    if (this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.sourceId + ") on element sourceId.");
    }
    param1.writeDouble(this.sourceId);

    param1.writeShort(this.tacklersIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.tacklersIds.length) {
      if (this.tacklersIds[_loc2_] < -9.007199254740992E15
          || this.tacklersIds[_loc2_] > 9.007199254740992E15) {
        throw new Exception(
            "Forbidden value ("
                + this.tacklersIds[_loc2_]
                + ") on element 1 (starting at 1) of tacklersIds.");
      }
      param1.writeDouble(this.tacklersIds[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = NaN;
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
      _loc4_ = param1.readDouble();
      if (_loc4_ < -9.007199254740992E15 || _loc4_ > 9.007199254740992E15) {
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of tacklersIds.");
      }
      this.tacklersIds.push(_loc4_);
      _loc3_++;
    }
  }
}
