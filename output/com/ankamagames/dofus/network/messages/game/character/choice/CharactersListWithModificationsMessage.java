package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterToRecolorInformation;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterToRelookInformation;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharactersListWithModificationsMessage extends CharactersListMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<CharacterToRecolorInformation> charactersToRecolor;
  public Vector<Integer> charactersToRename;
  public Vector<Integer> unusableCharacters;
  public Vector<CharacterToRelookInformation> charactersToRelook;
  private FuncTree _charactersToRecolortree;
  private FuncTree _charactersToRenametree;
  private FuncTree _unusableCharacterstree;
  private FuncTree _charactersToRelooktree;
  public static final int protocolId = 6120;

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

    param1.writeShort(this.charactersToRecolor.length);
    int _loc2_ = 0;
    while (_loc2_ < this.charactersToRecolor.length) {
      ((CharacterToRecolorInformation) this.charactersToRecolor[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    param1.writeShort(this.charactersToRename.length);
    int _loc3_ = 0;
    while (_loc3_ < this.charactersToRename.length) {
      param1.writeInt(this.charactersToRename[_loc3_]);
      _loc3_++;
    }
    param1.writeShort(this.unusableCharacters.length);
    int _loc4_ = 0;
    while (_loc4_ < this.unusableCharacters.length) {
      param1.writeInt(this.unusableCharacters[_loc4_]);
      _loc4_++;
    }
    param1.writeShort(this.charactersToRelook.length);
    int _loc5_ = 0;
    while (_loc5_ < this.charactersToRelook.length) {
      ((CharacterToRelookInformation) this.charactersToRelook[_loc5_]).serializeAs_(param1);
      _loc5_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    CharacterToRecolorInformation _loc10_ = null;
    Object _loc11_ = 0;
    Object _loc12_ = 0;
    CharacterToRelookInformation _loc13_ = null;
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

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc10_ = new CharacterToRecolorInformation();
      _loc10_.deserialize(param1);
      this.charactersToRecolor.push(_loc10_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc11_ = param1.readInt();
      this.charactersToRename.push(_loc11_);
      _loc5_++;
    }
    int _loc6_ = param1.readUnsignedShort();
    int _loc7_ = 0;
    while (_loc7_ < _loc6_) {
      _loc12_ = param1.readInt();
      this.unusableCharacters.push(_loc12_);
      _loc7_++;
    }
    int _loc8_ = param1.readUnsignedShort();
    int _loc9_ = 0;
    while (_loc9_ < _loc8_) {
      _loc13_ = new CharacterToRelookInformation();
      _loc13_.deserialize(param1);
      this.charactersToRelook.push(_loc13_);
      _loc9_++;
    }
  }
}
