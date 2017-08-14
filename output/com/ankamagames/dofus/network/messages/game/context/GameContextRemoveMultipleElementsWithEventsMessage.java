package com.ankamagames.dofus.network.messages.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameContextRemoveMultipleElementsWithEventsMessage
    extends GameContextRemoveMultipleElementsMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> elementEventIds;
  private FuncTree _elementEventIdstree;
  public static final int protocolId = 6416;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.elementsIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.elementsIds.length) {
      if (this.elementsIds[_loc2_] < -9.007199254740992E15
          || this.elementsIds[_loc2_] > 9.007199254740992E15) {
        throw new Exception(
            "Forbidden value ("
                + this.elementsIds[_loc2_]
                + ") on element 1 (starting at 1) of elementsIds.");
      }
      param1.writeDouble(this.elementsIds[_loc2_]);
      _loc2_++;
    }

    param1.writeShort(this.elementEventIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.elementEventIds.length) {
      if (this.elementEventIds[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.elementEventIds[_loc2_]
                + ") on element 1 (starting at 1) of elementEventIds.");
      }
      param1.writeByte(this.elementEventIds[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
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
      _loc4_ = param1.readByte();
      if (_loc4_ < 0) {
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of elementEventIds.");
      }
      this.elementEventIds.push(_loc4_);
      _loc3_++;
    }
  }
}
