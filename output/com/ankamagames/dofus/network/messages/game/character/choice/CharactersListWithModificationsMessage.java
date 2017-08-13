package package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterToRecolorInformation;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterToRelookInformation;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharactersListWithModificationsMessage extends CharactersListMessage implements INetworkMessage {

    private int protocolId = 6120;
    private boolean _isInitialized = false;
    private Vector.<CharacterToRecolorInformation> charactersToRecolor = ;
    private Vector.<int> charactersToRename = ;
    private Vector.<int> unusableCharacters = ;
    private Vector.<CharacterToRelookInformation> charactersToRelook = ;
    private FuncTree _charactersToRecolortree = ;
    private FuncTree _charactersToRenametree = ;
    private FuncTree _unusableCharacterstree = ;
    private FuncTree _charactersToRelooktree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc4_ = 0;
    private int _loc5_ = 0;
    private * _loc11_ = 0;
    private * _loc12_ = 0;
    private CharacterToRelookInformation _loc13_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc6_ = param1.readUnsignedShort();
    private int _loc7_ = 0;
    private int _loc8_ = param1.readUnsignedShort();
    private int _loc9_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6120;
    }

    public CharactersListWithModificationsMessage initCharactersListWithModificationsMessage(Vector.<CharacterBaseInformations> param1,boolean  param2,Vector.<CharacterToRecolorInformation>  param3,Vector.<int>  param4,Vector.<int>  param5,Vector.<CharacterToRelookInformation>  param6) {
         super.initCharactersListMessage(param1,param2);
         this.charactersToRecolor = param3;
         this.charactersToRename = param4;
         this.unusableCharacters = param5;
         this.charactersToRelook = param6;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.charactersToRecolor = new Vector.<CharacterToRecolorInformation>();
         this.charactersToRename = new Vector.<int>();
         this.unusableCharacters = new Vector.<int>();
         this.charactersToRelook = new Vector.<CharacterToRelookInformation>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharactersListWithModificationsMessage(param1);
    }

    public void serializeAs_CharactersListWithModificationsMessage(ICustomDataOutput param1) {
         super.serializeAs_CharactersListMessage(param1);
         param1.writeShort(this.charactersToRecolor.length);
         int _loc2_ = 0;
         while(_loc2_ < this.charactersToRecolor.length)
            (this.charactersToRecolor[_loc2_] as CharacterToRecolorInformation).serializeAs_CharacterToRecolorInformation(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharactersListWithModificationsMessage(param1);
    }

    public void deserializeAs_CharactersListWithModificationsMessage(ICustomDataInput param1) {
         CharacterToRecolorInformation _loc10_ = null;
         * _loc11_ = 0;
         * _loc12_ = 0;
         CharacterToRelookInformation _loc13_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc10_ = new CharacterToRecolorInformation();
            _loc10_.deserialize(param1);
            this.charactersToRecolor.push(_loc10_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharactersListWithModificationsMessage(param1);
    }

    public void deserializeAsyncAs_CharactersListWithModificationsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._charactersToRecolortree = param1.addChild(this._charactersToRecolortreeFunc);
         this._charactersToRenametree = param1.addChild(this._charactersToRenametreeFunc);
         this._unusableCharacterstree = param1.addChild(this._unusableCharacterstreeFunc);
         this._charactersToRelooktree = param1.addChild(this._charactersToRelooktreeFunc);
    }

    private void _charactersToRecolortreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._charactersToRecolortree.addChild(this._charactersToRecolorFunc);
            _loc3_++;
    }

    private void _charactersToRecolorFunc(ICustomDataInput param1) {
         CharacterToRecolorInformation _loc2_ = new CharacterToRecolorInformation();
         _loc2_.deserialize(param1);
         this.charactersToRecolor.push(_loc2_);
    }

    private void _charactersToRenametreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._charactersToRenametree.addChild(this._charactersToRenameFunc);
            _loc3_++;
    }

    private void _charactersToRenameFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.charactersToRename.push(_loc2_);
    }

    private void _unusableCharacterstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._unusableCharacterstree.addChild(this._unusableCharactersFunc);
            _loc3_++;
    }

    private void _unusableCharactersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.unusableCharacters.push(_loc2_);
    }

    private void _charactersToRelooktreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._charactersToRelooktree.addChild(this._charactersToRelookFunc);
            _loc3_++;
    }

    private void _charactersToRelookFunc(ICustomDataInput param1) {
         CharacterToRelookInformation _loc2_ = new CharacterToRelookInformation();
         _loc2_.deserialize(param1);
         this.charactersToRelook.push(_loc2_);
    }

}