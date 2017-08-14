package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicAllianceInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterMinimalAllianceInformations extends CharacterMinimalGuildInformations
    implements INetworkType {

  public BasicAllianceInformations alliance;
  private FuncTree _alliancetree;
  public static final int protocolId = 444;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);

    param1.writeUTF(this.name);

    if (this.level < 1 || this.level > 206) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);

    this.entityLook.serializeAs_EntityLook(param1);

    this.guild.serializeAs_BasicGuildInformations(param1);

    this.alliance.serializeAs_BasicAllianceInformations(param1);
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

    this.alliance = new BasicAllianceInformations();
    this.alliance.deserialize(param1);
  }
}
