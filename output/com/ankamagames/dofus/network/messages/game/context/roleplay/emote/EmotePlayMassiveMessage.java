package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class EmotePlayMassiveMessage extends EmotePlayAbstractMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<Number> actorIds;
  private FuncTree _actorIdstree;
  public static final int protocolId = 5691;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.emoteId < 0 || this.emoteId > 255) {
      throw new Error("Forbidden value (" + this.emoteId + ") on element emoteId.");
    }
    param1.writeByte(this.emoteId);
    if (this.emoteStartTime < -9.007199254740992E15 || this.emoteStartTime > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.emoteStartTime + ") on element emoteStartTime.");
    }
    param1.writeDouble(this.emoteStartTime);

    param1.writeShort(this.actorIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.actorIds.length) {
      if (this.actorIds[_loc2_] < -9.007199254740992E15
          || this.actorIds[_loc2_] > 9.007199254740992E15) {
        throw new Error(
            "Forbidden value ("
                + this.actorIds[_loc2_]
                + ") on element 1 (starting at 1) of actorIds.");
      }
      param1.writeDouble(this.actorIds[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = NaN;
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
      _loc4_ = param1.readDouble();
      if (_loc4_ < -9.007199254740992E15 || _loc4_ > 9.007199254740992E15) {
        throw new Error("Forbidden value (" + _loc4_ + ") on elements of actorIds.");
      }
      this.actorIds.push(_loc4_);
      _loc3_++;
    }
  }
}
