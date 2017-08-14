package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt.TreasureHuntStep;
import com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt.TreasureHuntFlag;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class TreasureHuntMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int questType = 0;
  public int startMapId = 0;
  public Vector<TreasureHuntStep> knownStepsList;
  public int totalStepCount = 0;
  public int checkPointCurrent = 0;
  public int checkPointTotal = 0;
  public int availableRetryCount = 0;
  public Vector<TreasureHuntFlag> flags;
  private FuncTree _knownStepsListtree;
  private FuncTree _flagstree;
  public static final int protocolId = 6486;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.questType);
    param1.writeInt(this.startMapId);
    param1.writeShort(this.knownStepsList.length);
    int _loc2_ = 0;
    while (_loc2_ < this.knownStepsList.length) {
      param1.writeShort(((TreasureHuntStep) (this.knownStepsList[_loc2_])).getTypeId());
      ((TreasureHuntStep) this.knownStepsList[_loc2_]).serialize(param1);
      _loc2_++;
    }
    if (this.totalStepCount < 0) {
      throw new Error("Forbidden value (" + this.totalStepCount + ") on element totalStepCount.");
    }
    param1.writeByte(this.totalStepCount);
    if (this.checkPointCurrent < 0) {
      throw new Error(
          "Forbidden value (" + this.checkPointCurrent + ") on element checkPointCurrent.");
    }
    param1.writeVarInt(this.checkPointCurrent);
    if (this.checkPointTotal < 0) {
      throw new Error("Forbidden value (" + this.checkPointTotal + ") on element checkPointTotal.");
    }
    param1.writeVarInt(this.checkPointTotal);
    param1.writeInt(this.availableRetryCount);
    param1.writeShort(this.flags.length);
    int _loc3_ = 0;
    while (_loc3_ < this.flags.length) {
      ((TreasureHuntFlag) this.flags[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    TreasureHuntStep _loc7_ = null;
    TreasureHuntFlag _loc8_ = null;
    this.questType = param1.readByte();
    if (this.questType < 0) {
      throw new Error(
          "Forbidden value ("
              + this.questType
              + ") on element of TreasureHuntRequestMessage.questType.");
    }

    this.startMapId = param1.readInt();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readUnsignedShort();
      _loc7_ = ProtocolTypeManager.getInstance(TreasureHuntStep, _loc6_);
      _loc7_.deserialize(param1);
      this.knownStepsList.push(_loc7_);
      _loc3_++;
    }
    this.totalStepCount = param1.readByte();
    if (this.totalStepCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.totalStepCount
              + ") on element of TreasureHuntMessage.totalStepCount.");
    }

    this.checkPointCurrent = param1.readVarUhInt();
    if (this.checkPointCurrent < 0) {
      throw new Error(
          "Forbidden value ("
              + this.checkPointCurrent
              + ") on element of TreasureHuntMessage.checkPointCurrent.");
    }

    this.checkPointTotal = param1.readVarUhInt();
    if (this.checkPointTotal < 0) {
      throw new Error(
          "Forbidden value ("
              + this.checkPointTotal
              + ") on element of TreasureHuntMessage.checkPointTotal.");
    }

    this.availableRetryCount = param1.readInt();

    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc8_ = new TreasureHuntFlag();
      _loc8_.deserialize(param1);
      this.flags.push(_loc8_);
      _loc5_++;
    }
  }
}
