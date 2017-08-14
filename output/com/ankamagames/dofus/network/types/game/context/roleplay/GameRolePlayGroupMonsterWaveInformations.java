package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayGroupMonsterWaveInformations extends GameRolePlayGroupMonsterInformations
    implements INetworkType {

  public int nbWaves = 0;
  public Vector<GroupMonsterStaticInformations> alternatives;
  private FuncTree _alternativestree;
  public static final int protocolId = 464;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.contextualId + ") on element contextualId.");
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
      throw new Error("Forbidden value (" + this.creationTime + ") on element creationTime.");
    }
    param1.writeDouble(this.creationTime);
    if (this.ageBonusRate < 0) {
      throw new Error("Forbidden value (" + this.ageBonusRate + ") on element ageBonusRate.");
    }
    param1.writeInt(this.ageBonusRate);
    if (this.lootShare < -1 || this.lootShare > 8) {
      throw new Error("Forbidden value (" + this.lootShare + ") on element lootShare.");
    }
    param1.writeByte(this.lootShare);
    param1.writeByte(this.alignmentSide);

    if (this.nbWaves < 0) {
      throw new Error("Forbidden value (" + this.nbWaves + ") on element nbWaves.");
    }
    param1.writeByte(this.nbWaves);
    param1.writeShort(this.alternatives.length);
    int _loc2_ = 0;
    while (_loc2_ < this.alternatives.length) {
      param1.writeShort(((GroupMonsterStaticInformations) (this.alternatives[_loc2_])).getTypeId());
      ((GroupMonsterStaticInformations) this.alternatives[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    GroupMonsterStaticInformations _loc5_ = null;
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

    this.nbWaves = param1.readByte();
    if (this.nbWaves < 0) {
      throw new Error(
          "Forbidden value ("
              + this.nbWaves
              + ") on element of GameRolePlayGroupMonsterWaveInformations.nbWaves.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(GroupMonsterStaticInformations, _loc4_);
      _loc5_.deserialize(param1);
      this.alternatives.push(_loc5_);
      _loc3_++;
    }
  }
}
