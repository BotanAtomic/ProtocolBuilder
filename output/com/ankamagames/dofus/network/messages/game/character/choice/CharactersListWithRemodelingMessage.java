package package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterToRemodelInformations;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharactersListWithRemodelingMessage extends CharactersListMessage implements INetworkMessage {

    private int protocolId = 6550;
    private boolean _isInitialized = false;
    private Vector.<CharacterToRemodelInformations> charactersToRemodel = ;
    private FuncTree _charactersToRemodeltree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6550;
    }

    public CharactersListWithRemodelingMessage initCharactersListWithRemodelingMessage(Vector.<CharacterBaseInformations> param1,boolean  param2,Vector.<CharacterToRemodelInformations>  param3) {
         super.initCharactersListMessage(param1,param2);
         this.charactersToRemodel = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.charactersToRemodel = new Vector.<CharacterToRemodelInformations>();
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
         this.serializeAs_CharactersListWithRemodelingMessage(param1);
    }

    public void serializeAs_CharactersListWithRemodelingMessage(ICustomDataOutput param1) {
         super.serializeAs_CharactersListMessage(param1);
         param1.writeShort(this.charactersToRemodel.length);
         int _loc2_ = 0;
         while(_loc2_ < this.charactersToRemodel.length)
            (this.charactersToRemodel[_loc2_] as CharacterToRemodelInformations).serializeAs_CharacterToRemodelInformations(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharactersListWithRemodelingMessage(param1);
    }

    public void deserializeAs_CharactersListWithRemodelingMessage(ICustomDataInput param1) {
         CharacterToRemodelInformations _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new CharacterToRemodelInformations();
            _loc4_.deserialize(param1);
            this.charactersToRemodel.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharactersListWithRemodelingMessage(param1);
    }

    public void deserializeAsyncAs_CharactersListWithRemodelingMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._charactersToRemodeltree = param1.addChild(this._charactersToRemodeltreeFunc);
    }

    private void _charactersToRemodeltreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._charactersToRemodeltree.addChild(this._charactersToRemodelFunc);
            _loc3_++;
    }

    private void _charactersToRemodelFunc(ICustomDataInput param1) {
         CharacterToRemodelInformations _loc2_ = new CharacterToRemodelInformations();
         _loc2_.deserialize(param1);
         this.charactersToRemodel.push(_loc2_);
    }

}