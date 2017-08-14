package com.ankamagames.dofus.network.messages.game.alliance;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicAllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KohUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<AllianceInformations> alliances;
  public Vector<uint> allianceNbMembers;
  public Vector<uint> allianceRoundWeigth;
  public Vector<uint> allianceMatchScore;
  public BasicAllianceInformations allianceMapWinner;
  public int allianceMapWinnerScore = 0;
  public int allianceMapMyAllianceScore = 0;
  public Number nextTickTime = 0;
  private FuncTree _alliancestree;
  private FuncTree _allianceNbMemberstree;
  private FuncTree _allianceRoundWeigthtree;
  private FuncTree _allianceMatchScoretree;
  private FuncTree _allianceMapWinnertree;
  public static final int protocolId = 6439;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.alliances.length);
    int _loc2_ = 0;
    while (_loc2_ < this.alliances.length) {
      ((AllianceInformations) this.alliances[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    param1.writeShort(this.allianceNbMembers.length);
    int _loc3_ = 0;
    while (_loc3_ < this.allianceNbMembers.length) {
      if (this.allianceNbMembers[_loc3_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.allianceNbMembers[_loc3_]
                + ") on element 2 (starting at 1) of allianceNbMembers.");
      }
      param1.writeVarShort(this.allianceNbMembers[_loc3_]);
      _loc3_++;
    }
    param1.writeShort(this.allianceRoundWeigth.length);
    int _loc4_ = 0;
    while (_loc4_ < this.allianceRoundWeigth.length) {
      if (this.allianceRoundWeigth[_loc4_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.allianceRoundWeigth[_loc4_]
                + ") on element 3 (starting at 1) of allianceRoundWeigth.");
      }
      param1.writeVarInt(this.allianceRoundWeigth[_loc4_]);
      _loc4_++;
    }
    param1.writeShort(this.allianceMatchScore.length);
    int _loc5_ = 0;
    while (_loc5_ < this.allianceMatchScore.length) {
      if (this.allianceMatchScore[_loc5_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.allianceMatchScore[_loc5_]
                + ") on element 4 (starting at 1) of allianceMatchScore.");
      }
      param1.writeByte(this.allianceMatchScore[_loc5_]);
      _loc5_++;
    }
    this.allianceMapWinner.serializeAs_BasicAllianceInformations(param1);
    if (this.allianceMapWinnerScore < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.allianceMapWinnerScore
              + ") on element allianceMapWinnerScore.");
    }
    param1.writeVarInt(this.allianceMapWinnerScore);
    if (this.allianceMapMyAllianceScore < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.allianceMapMyAllianceScore
              + ") on element allianceMapMyAllianceScore.");
    }
    param1.writeVarInt(this.allianceMapMyAllianceScore);
    if (this.nextTickTime < 0 || this.nextTickTime > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.nextTickTime + ") on element nextTickTime.");
    }
    param1.writeDouble(this.nextTickTime);
  }

  public void deserialize(ICustomDataInput param1) {
    AllianceInformations _loc10_ = null;
    int _loc11_ = 0;
    int _loc12_ = 0;
    int _loc13_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc10_ = new AllianceInformations();
      _loc10_.deserialize(param1);
      this.alliances.push(_loc10_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc11_ = param1.readVarUhShort();
      if (_loc11_ < 0) {
        throw new Exception("Forbidden value (" + _loc11_ + ") on elements of allianceNbMembers.");
      }
      this.allianceNbMembers.push(_loc11_);
      _loc5_++;
    }
    int _loc6_ = param1.readUnsignedShort();
    int _loc7_ = 0;
    while (_loc7_ < _loc6_) {
      _loc12_ = param1.readVarUhInt();
      if (_loc12_ < 0) {
        throw new Exception(
            "Forbidden value (" + _loc12_ + ") on elements of allianceRoundWeigth.");
      }
      this.allianceRoundWeigth.push(_loc12_);
      _loc7_++;
    }
    int _loc8_ = param1.readUnsignedShort();
    int _loc9_ = 0;
    while (_loc9_ < _loc8_) {
      _loc13_ = param1.readByte();
      if (_loc13_ < 0) {
        throw new Exception("Forbidden value (" + _loc13_ + ") on elements of allianceMatchScore.");
      }
      this.allianceMatchScore.push(_loc13_);
      _loc9_++;
    }
    this.allianceMapWinner = new BasicAllianceInformations();
    this.allianceMapWinner.deserialize(param1);
    this.allianceMapWinnerScore = param1.readVarUhInt();
    if (this.allianceMapWinnerScore < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.allianceMapWinnerScore
              + ") on element of KohUpdateMessage.allianceMapWinnerScore.");
    }

    this.allianceMapMyAllianceScore = param1.readVarUhInt();
    if (this.allianceMapMyAllianceScore < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.allianceMapMyAllianceScore
              + ") on element of KohUpdateMessage.allianceMapMyAllianceScore.");
    }

    this.nextTickTime = param1.readDouble();
    if (this.nextTickTime < 0 || this.nextTickTime > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.nextTickTime
              + ") on element of KohUpdateMessage.nextTickTime.");
    }
  }
}
