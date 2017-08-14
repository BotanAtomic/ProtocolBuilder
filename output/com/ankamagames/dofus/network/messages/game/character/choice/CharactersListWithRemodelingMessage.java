package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterToRemodelInformations;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharactersListWithRemodelingMessage extends CharactersListMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<CharacterToRemodelInformations> charactersToRemodel;
  private FuncTree _charactersToRemodeltree;
  public static final int protocolId = 6550;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.characters.length);
    int _loc2_ = 0;
    while (_loc2_ < this.characters.length) {
      param1.writeShort(((CharacterBaseInformations) (this.characters[_loc2_])).getTypeId());
      ((CharacterBaseInformations) this.characters[_loc2_]).serialize(param1);
      _loc2_++;
    }

    param1.writeBoolean(this.hasStartupActions);

    param1.writeShort(this.charactersToRemodel.length);
    int _loc2_ = 0;
    while (_loc2_ < this.charactersToRemodel.length) {
      ((CharacterToRemodelInformations) this.charactersToRemodel[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    CharacterToRemodelInformations _loc4_ = null;
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

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new CharacterToRemodelInformations();
      _loc4_.deserialize(param1);
      this.charactersToRemodel.push(_loc4_);
      _loc3_++;
    }
  }
}
