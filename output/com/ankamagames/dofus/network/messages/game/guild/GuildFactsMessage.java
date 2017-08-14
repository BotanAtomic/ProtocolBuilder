package com.ankamagames.dofus.network.messages.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.GuildFactSheetInformations;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GuildFactsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public GuildFactSheetInformations infos;
  public int creationDate = 0;
  public int nbTaxCollectors = 0;
  public Vector<CharacterMinimalInformations> members;
  private FuncTree _infostree;
  private FuncTree _memberstree;
  public static final int protocolId = 6415;

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
  }

  public void deserialize(ICustomDataInput param1) {
    CharacterMinimalInformations _loc5_ = null;
    int _loc2_ = param1.readUnsignedShort();
    this.infos = ProtocolTypeManager.getInstance(GuildFactSheetInformations, _loc2_);
    this.infos.deserialize(param1);
    this.creationDate = param1.readInt();
    if (this.creationDate < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.creationDate
              + ") on element of AllianceFactSheetInformations.creationDate.");
    }

    this.nbTaxCollectors = param1.readByte();
    if (this.nbTaxCollectors < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.nbTaxCollectors
              + ") on element of GuildInsiderFactSheetInformations.nbTaxCollectors.");
    }

    int _loc3_ = param1.readUnsignedShort();
    int _loc4_ = 0;
    while (_loc4_ < _loc3_) {
      _loc5_ = new CharacterMinimalInformations();
      _loc5_.deserialize(param1);
      this.members.push(_loc5_);
      _loc4_++;
    }
  }
}
