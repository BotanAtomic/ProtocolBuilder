package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobMultiCraftAvailableSkillsMessage extends JobAllowMultiCraftRequestMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number playerId = 0;
  public Vector<uint> skills;
  private FuncTree _skillstree;
  public static final int protocolId = 5747;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.enabled);

    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
    param1.writeShort(this.skills.length);
    int _loc2_ = 0;
    while (_loc2_ < this.skills.length) {
      if (this.skills[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.skills[_loc2_]
                + ") on element 2 (starting at 1) of skills.");
      }
      param1.writeVarShort(this.skills[_loc2_]);
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

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readVarUhShort();
      if (_loc4_ < 0) {
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of skills.");
      }
      this.skills.push(_loc4_);
      _loc3_++;
    }
  }
}
