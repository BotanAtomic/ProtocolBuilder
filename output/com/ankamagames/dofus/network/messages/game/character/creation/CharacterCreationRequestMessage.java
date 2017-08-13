package package com.ankamagames.dofus.network.messages.game.character.creation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterCreationRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 160;
    private boolean _isInitialized = false;
    private String name = "";
    private int breed = 0;
    private boolean sex = false;
    private Vector.<int> colors = ;
    private int cosmeticId = 0;
    private FuncTree _colorstree = ;
    private int _colorsindex = 0;
    private int _loc2_ = 0;
    private int _loc2_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 160;
    }

    public CharacterCreationRequestMessage initCharacterCreationRequestMessage(String param1,int  param2,boolean  param3,Vector.<int>  param4,int  param5) {
         this.name = param1;
         this.breed = param2;
         this.sex = param3;
         this.colors = param4;
         this.cosmeticId = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.name = "";
         this.breed = 0;
         this.sex = false;
         this.colors = new Vector.<int>(5,true);
         this.cosmeticId = 0;
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
         this.serializeAs_CharacterCreationRequestMessage(param1);
    }

    public void serializeAs_CharacterCreationRequestMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.name);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
         int _loc2_ = 0;
         while(_loc2_ < 5)
            param1.writeInt(this.colors[_loc2_]);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterCreationRequestMessage(param1);
    }

    public void deserializeAs_CharacterCreationRequestMessage(ICustomDataInput param1) {
         this._nameFunc(param1);
         this._breedFunc(param1);
         this._sexFunc(param1);
         int _loc2_ = 0;
         while(_loc2_ < 5)
            this.colors[_loc2_] = param1.readInt();
            _loc2_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterCreationRequestMessage(param1);
    }

    public void deserializeAsyncAs_CharacterCreationRequestMessage(FuncTree param1) {
         param1.addChild(this._nameFunc);
         param1.addChild(this._breedFunc);
         param1.addChild(this._sexFunc);
         this._colorstree = param1.addChild(this._colorstreeFunc);
         param1.addChild(this._cosmeticIdFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
         if(this.breed < PlayableBreedEnum.Feca || this.breed > PlayableBreedEnum.Ouginak)
            throw new Exception("Forbidden value (" + this.breed + ") on element of CharacterCreationRequestMessage.breed.");
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readBoolean();
    }

    private void _colorstreeFunc(ICustomDataInput param1) {
         int _loc2_ = 0;
         while(_loc2_ < 5)
            this._colorstree.addChild(this._colorsFunc);
            _loc2_++;
    }

    private void _colorsFunc(ICustomDataInput param1) {
         this.colors[this._colorsindex] = param1.readInt();
         this._colorsindex++;
    }

    private void _cosmeticIdFunc(ICustomDataInput param1) {
         this.cosmeticId = param1.readVarUhShort();
         if(this.cosmeticId < 0)
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element of CharacterCreationRequestMessage.cosmeticId.");
    }

}