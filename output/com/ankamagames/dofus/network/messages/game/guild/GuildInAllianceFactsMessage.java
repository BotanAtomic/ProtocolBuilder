package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.dofus.network.types.game.social.GuildFactSheetInformations;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInAllianceFactsMessage extends GuildFactsMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public BasicNamedAllianceInformations allianceInfos;
  private FuncTree _allianceInfostree;
  public static final int protocolId = 6422;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.infos.getTypeId());
    this.infos.serialize(param1);
    if (this.creationDate < 0) {
      throw new Exception("Forbidden value (" + this.creationDate + ") on element creationDate.");
    }
    param1.writeInt(this.creationDate);
    if (this.nbTaxCollectors < 0) {
      throw new Exception(
          "Forbidden value (" + this.nbTaxCollectors + ") on element nbTaxCollectors.");
    }
    param1.writeVarShort(this.nbTaxCollectors);
    param1.writeShort(this.members.length);
    int _loc2_ = 0;
    while (_loc2_ < this.members.length) {
      ((CharacterMinimalInformations) this.members[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }

    this.allianceInfos.serializeAs_BasicNamedAllianceInformations(param1);
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

    this.allianceInfos = new BasicNamedAllianceInformations();
    this.allianceInfos.deserialize(param1);
  }
}
