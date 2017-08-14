package com.ankamagames.dofus.network.messages.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInfosUpgradeMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int maxTaxCollectorsCount = 0;
  public int taxCollectorsCount = 0;
  public int taxCollectorLifePoints = 0;
  public int taxCollectorDamagesBonuses = 0;
  public int taxCollectorPods = 0;
  public int taxCollectorProspecting = 0;
  public int taxCollectorWisdom = 0;
  public int boostPoints = 0;
  public Vector<uint> spellId;
  public Vector<Integer> spellLevel;
  private FuncTree _spellIdtree;
  private FuncTree _spellLeveltree;
  public static final int protocolId = 5636;

  public void serialize(ICustomDataOutput param1) {
    if (this.maxTaxCollectorsCount < 0) {
      throw new Error(
          "Forbidden value (" + this.maxTaxCollectorsCount + ") on element maxTaxCollectorsCount.");
    }
    param1.writeByte(this.maxTaxCollectorsCount);
    if (this.taxCollectorsCount < 0) {
      throw new Error(
          "Forbidden value (" + this.taxCollectorsCount + ") on element taxCollectorsCount.");
    }
    param1.writeByte(this.taxCollectorsCount);
    if (this.taxCollectorLifePoints < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorLifePoints
              + ") on element taxCollectorLifePoints.");
    }
    param1.writeVarShort(this.taxCollectorLifePoints);
    if (this.taxCollectorDamagesBonuses < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorDamagesBonuses
              + ") on element taxCollectorDamagesBonuses.");
    }
    param1.writeVarShort(this.taxCollectorDamagesBonuses);
    if (this.taxCollectorPods < 0) {
      throw new Error(
          "Forbidden value (" + this.taxCollectorPods + ") on element taxCollectorPods.");
    }
    param1.writeVarShort(this.taxCollectorPods);
    if (this.taxCollectorProspecting < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorProspecting
              + ") on element taxCollectorProspecting.");
    }
    param1.writeVarShort(this.taxCollectorProspecting);
    if (this.taxCollectorWisdom < 0) {
      throw new Error(
          "Forbidden value (" + this.taxCollectorWisdom + ") on element taxCollectorWisdom.");
    }
    param1.writeVarShort(this.taxCollectorWisdom);
    if (this.boostPoints < 0) {
      throw new Error("Forbidden value (" + this.boostPoints + ") on element boostPoints.");
    }
    param1.writeVarShort(this.boostPoints);
    param1.writeShort(this.spellId.length);
    int _loc2_ = 0;
    while (_loc2_ < this.spellId.length) {
      if (this.spellId[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.spellId[_loc2_]
                + ") on element 9 (starting at 1) of spellId.");
      }
      param1.writeVarShort(this.spellId[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.spellLevel.length);
    int _loc3_ = 0;
    while (_loc3_ < this.spellLevel.length) {
      param1.writeShort(this.spellLevel[_loc3_]);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    Object _loc7_ = 0;
    this.maxTaxCollectorsCount = param1.readByte();
    if (this.maxTaxCollectorsCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.maxTaxCollectorsCount
              + ") on element of GuildInfosUpgradeMessage.maxTaxCollectorsCount.");
    }

    this.taxCollectorsCount = param1.readByte();
    if (this.taxCollectorsCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorsCount
              + ") on element of GuildInfosUpgradeMessage.taxCollectorsCount.");
    }

    this.taxCollectorLifePoints = param1.readVarUhShort();
    if (this.taxCollectorLifePoints < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorLifePoints
              + ") on element of GuildInfosUpgradeMessage.taxCollectorLifePoints.");
    }

    this.taxCollectorDamagesBonuses = param1.readVarUhShort();
    if (this.taxCollectorDamagesBonuses < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorDamagesBonuses
              + ") on element of GuildInfosUpgradeMessage.taxCollectorDamagesBonuses.");
    }

    this.taxCollectorPods = param1.readVarUhShort();
    if (this.taxCollectorPods < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorPods
              + ") on element of GuildInfosUpgradeMessage.taxCollectorPods.");
    }

    this.taxCollectorProspecting = param1.readVarUhShort();
    if (this.taxCollectorProspecting < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorProspecting
              + ") on element of GuildInfosUpgradeMessage.taxCollectorProspecting.");
    }

    this.taxCollectorWisdom = param1.readVarUhShort();
    if (this.taxCollectorWisdom < 0) {
      throw new Error(
          "Forbidden value ("
              + this.taxCollectorWisdom
              + ") on element of GuildInfosUpgradeMessage.taxCollectorWisdom.");
    }

    this.boostPoints = param1.readVarUhShort();
    if (this.boostPoints < 0) {
      throw new Error(
          "Forbidden value ("
              + this.boostPoints
              + ") on element of GuildInfosUpgradeMessage.boostPoints.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readVarUhShort();
      if (_loc6_ < 0) {
        throw new Error("Forbidden value (" + _loc6_ + ") on elements of spellId.");
      }
      this.spellId.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = param1.readShort();
      this.spellLevel.push(_loc7_);
      _loc5_++;
    }
  }
}
