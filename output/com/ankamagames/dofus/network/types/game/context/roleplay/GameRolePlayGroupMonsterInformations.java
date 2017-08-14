package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayGroupMonsterInformations extends GameRolePlayActorInformations
    implements INetworkType {

  public GroupMonsterStaticInformations staticInfos;
  public Number creationTime = 0;
  public int ageBonusRate = 0;
  public int lootShare = 0;
  public int alignmentSide = 0;
  public boolean keyRingBonus = false;
  public boolean hasHardcoreDrop = false;
  public boolean hasAVARewardToken = false;
  private FuncTree _staticInfostree;
  public static final int protocolId = 160;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);

    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.keyRingBonus);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.hasHardcoreDrop);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.hasAVARewardToken);
    param1.writeByte(_loc2_);
    param1.writeShort(this.staticInfos.getTypeId());
    this.staticInfos.serialize(param1);
    if (this.creationTime < 0 || this.creationTime > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.creationTime + ") on element creationTime.");
    }
    param1.writeDouble(this.creationTime);
    if (this.ageBonusRate < 0) {
      throw new Exception("Forbidden value (" + this.ageBonusRate + ") on element ageBonusRate.");
    }
    param1.writeInt(this.ageBonusRate);
    if (this.lootShare < -1 || this.lootShare > 8) {
      throw new Exception("Forbidden value (" + this.lootShare + ") on element lootShare.");
    }
    param1.writeByte(this.lootShare);
    param1.writeByte(this.alignmentSide);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
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

    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    int _loc2_ = param1.readUnsignedShort();
    this.staticInfos = ProtocolTypeManager.getInstance(GroupMonsterStaticInformations, _loc2_);
    this.staticInfos.deserialize(param1);
    this.creationTime = param1.readDouble();
    if (this.creationTime < 0 || this.creationTime > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.creationTime
              + ") on element of GameRolePlayGroupMonsterInformations.creationTime.");
    }

    this.ageBonusRate = param1.readInt();
    if (this.ageBonusRate < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.ageBonusRate
              + ") on element of GameRolePlayGroupMonsterInformations.ageBonusRate.");
    }

    this.lootShare = param1.readByte();
    if (this.lootShare < -1 || this.lootShare > 8) {
      throw new Exception(
          "Forbidden value ("
              + this.lootShare
              + ") on element of GameRolePlayGroupMonsterInformations.lootShare.");
    }

    this.alignmentSide = param1.readByte();
  }
}
