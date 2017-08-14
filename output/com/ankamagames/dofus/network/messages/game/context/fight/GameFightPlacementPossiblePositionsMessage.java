package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightPlacementPossiblePositionsMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> positionsForChallengers;
  public Vector<uint> positionsForDefenders;
  public int teamNumber = 2;
  private FuncTree _positionsForChallengerstree;
  private FuncTree _positionsForDefenderstree;
  public static final int protocolId = 703;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.positionsForChallengers.length);
    int _loc2_ = 0;
    while (_loc2_ < this.positionsForChallengers.length) {
      if (this.positionsForChallengers[_loc2_] < 0 || this.positionsForChallengers[_loc2_] > 559) {
        throw new Error(
            "Forbidden value ("
                + this.positionsForChallengers[_loc2_]
                + ") on element 1 (starting at 1) of positionsForChallengers.");
      }
      param1.writeVarShort(this.positionsForChallengers[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.positionsForDefenders.length);
    int _loc3_ = 0;
    while (_loc3_ < this.positionsForDefenders.length) {
      if (this.positionsForDefenders[_loc3_] < 0 || this.positionsForDefenders[_loc3_] > 559) {
        throw new Error(
            "Forbidden value ("
                + this.positionsForDefenders[_loc3_]
                + ") on element 2 (starting at 1) of positionsForDefenders.");
      }
      param1.writeVarShort(this.positionsForDefenders[_loc3_]);
      _loc3_++;
    }
    param1.writeByte(this.teamNumber);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    int _loc7_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readVarUhShort();
      if (_loc6_ < 0 || _loc6_ > 559) {
        throw new Error("Forbidden value (" + _loc6_ + ") on elements of positionsForChallengers.");
      }
      this.positionsForChallengers.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = param1.readVarUhShort();
      if (_loc7_ < 0 || _loc7_ > 559) {
        throw new Error("Forbidden value (" + _loc7_ + ") on elements of positionsForDefenders.");
      }
      this.positionsForDefenders.push(_loc7_);
      _loc5_++;
    }
    this.teamNumber = param1.readByte();
    if (this.teamNumber < 0) {
      throw new Error(
          "Forbidden value ("
              + this.teamNumber
              + ") on element of GameFightPlacementPossiblePositionsMessage.teamNumber.");
    }
  }
}
