package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayMerchantInformations extends GameRolePlayNamedActorInformations
    implements INetworkType {

  public int sellType = 0;
  public Vector<HumanOption> options;
  private FuncTree _optionstree;
  public static final int protocolId = 129;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);

    param1.writeUTF(this.name);

    if (this.sellType < 0) {
      throw new Exception("Forbidden value (" + this.sellType + ") on element sellType.");
    }
    param1.writeByte(this.sellType);
    param1.writeShort(this.options.length);
    int _loc2_ = 0;
    while (_loc2_ < this.options.length) {
      param1.writeShort(((HumanOption) (this.options[_loc2_])).getTypeId());
      ((HumanOption) this.options[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    HumanOption _loc5_ = null;
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

    this.sellType = param1.readByte();
    if (this.sellType < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.sellType
              + ") on element of GameRolePlayMerchantInformations.sellType.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(HumanOption, _loc4_);
      _loc5_.deserialize(param1);
      this.options.push(_loc5_);
      _loc3_++;
    }
  }
}
