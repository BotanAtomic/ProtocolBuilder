package package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.dofus.network.types.game.character.AbstractCharacterInformation;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterRemodelingInformation extends AbstractCharacterInformation implements INetworkType {

    private int protocolId = 479;
    private String name = "";
    private int breed = 0;
    private boolean sex = false;
    private int cosmeticId = 0;
    private Vector.<int> colors = ;
    private FuncTree _colorstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 479;
    }

    public CharacterRemodelingInformation initCharacterRemodelingInformation(Number param1,String  param2,int  param3,boolean  param4,int  param5,Vector.<int>  param6) {
         super.initAbstractCharacterInformation(param1);
         this.name = param2;
         this.breed = param3;
         this.sex = param4;
         this.cosmeticId = param5;
         this.colors = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.name = "";
         this.breed = 0;
         this.sex = false;
         this.cosmeticId = 0;
         this.colors = new Vector.<int>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterRemodelingInformation(param1);
    }

    public void serializeAs_CharacterRemodelingInformation(ICustomDataOutput param1) {
         super.serializeAs_AbstractCharacterInformation(param1);
         param1.writeUTF(this.name);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
         if(this.cosmeticId < 0)
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element cosmeticId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterRemodelingInformation(param1);
    }

    public void deserializeAs_CharacterRemodelingInformation(ICustomDataInput param1) {
         * _loc4_ = 0;
         super.deserialize(param1);
         this._nameFunc(param1);
         this._breedFunc(param1);
         this._sexFunc(param1);
         this._cosmeticIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readInt();
            this.colors.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterRemodelingInformation(param1);
    }

    public void deserializeAsyncAs_CharacterRemodelingInformation(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nameFunc);
         param1.addChild(this._breedFunc);
         param1.addChild(this._sexFunc);
         param1.addChild(this._cosmeticIdFunc);
         this._colorstree = param1.addChild(this._colorstreeFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readBoolean();
    }

    private void _cosmeticIdFunc(ICustomDataInput param1) {
         this.cosmeticId = param1.readVarUhShort();
         if(this.cosmeticId < 0)
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element of CharacterRemodelingInformation.cosmeticId.");
    }

    private void _colorstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._colorstree.addChild(this._colorsFunc);
            _loc3_++;
    }

    private void _colorsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.colors.push(_loc2_);
    }

}