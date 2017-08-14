package com.ankamagames.dofus.network.types.game.friend;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FriendSpouseOnlineInformations extends FriendSpouseInformations
    implements INetworkType {

  public int mapId = 0;
  public int subAreaId = 0;
  public boolean inFight = false;
  public boolean followSpouse = false;
  public static final int protocolId = 93;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.spouseAccountId < 0) {
      throw new Error("Forbidden value (" + this.spouseAccountId + ") on element spouseAccountId.");
    }
    param1.writeInt(this.spouseAccountId);
    if (this.spouseId < 0 || this.spouseId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.spouseId + ") on element spouseId.");
    }
    param1.writeVarLong(this.spouseId);
    param1.writeUTF(this.spouseName);
    if (this.spouseLevel < 1 || this.spouseLevel > 206) {
      throw new Error("Forbidden value (" + this.spouseLevel + ") on element spouseLevel.");
    }
    param1.writeByte(this.spouseLevel);
    param1.writeByte(this.breed);
    param1.writeByte(this.sex);
    this.spouseEntityLook.serializeAs_EntityLook(param1);
    this.guildInfo.serializeAs_GuildInformations(param1);
    param1.writeByte(this.alignmentSide);

    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.inFight);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.followSpouse);
    param1.writeByte(_loc2_);
    if (this.mapId < 0) {
      throw new Error("Forbidden value (" + this.mapId + ") on element mapId.");
    }
    param1.writeInt(this.mapId);
    if (this.subAreaId < 0) {
      throw new Error("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }
    param1.writeVarShort(this.subAreaId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
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

    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.mapId = param1.readInt();

    this.subAreaId = param1.readVarUhShort();
    if (this.subAreaId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.subAreaId
              + ") on element of PrismSubareaEmptyInfo.subAreaId.");
    }
  }
}
