package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class BasicCharactersListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6475;
    private boolean _isInitialized = false;
    private Vector<CharacterBaseInformations> characters;
    private FuncTree _characterstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6475;
    }

    public BasicCharactersListMessage initBasicCharactersListMessage(Vector<CharacterBaseInformations> param1) {
         this.characters = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.characters = new Vector.<CharacterBaseInformations>();
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
         this.serializeAs_BasicCharactersListMessage(param1);
    }

    public void serializeAs_BasicCharactersListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.characters.length);
         int _loc2_ = 0;
         while(_loc2_ < this.characters.length)
         {
            param1.writeShort((this.characters[_loc2_] as CharacterBaseInformations).getTypeId());
            (this.characters[_loc2_] as CharacterBaseInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicCharactersListMessage(param1);
    }

    public void deserializeAs_BasicCharactersListMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         CharacterBaseInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(CharacterBaseInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.characters.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicCharactersListMessage(param1);
    }

    public void deserializeAsyncAs_BasicCharactersListMessage(FuncTree param1) {
         this._characterstree = param1.addChild(this._characterstreeFunc);
    }

    private void _characterstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._characterstree.addChild(this._charactersFunc);
            _loc3_++;
         }
    }

    private void _charactersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         CharacterBaseInformations _loc3_ = ProtocolTypeManager.getInstance(CharacterBaseInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.characters.push(_loc3_);
    }

}