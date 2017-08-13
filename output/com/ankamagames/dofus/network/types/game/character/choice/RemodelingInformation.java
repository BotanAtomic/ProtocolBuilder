package package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class RemodelingInformation extends Object implements INetworkType {

    private int protocolId = 480;
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
         return 480;
    }

    public RemodelingInformation initRemodelingInformation(String param1,int  param2,boolean  param3,int  param4,Vector.<int>  param5) {
         this.name = param1;
         this.breed = param2;
         this.sex = param3;
         this.cosmeticId = param4;
         this.colors = param5;
         return this;
    }

    public void reset() {
         this.name = "";
         this.breed = 0;
         this.sex = false;
         this.cosmeticId = 0;
         this.colors = new Vector.<int>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_RemodelingInformation(param1);
    }

    public void serializeAs_RemodelingInformation(ICustomDataOutput param1) {
         param1.writeUTF(this.name);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
         if(this.cosmeticId < 0)
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element cosmeticId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_RemodelingInformation(param1);
    }

    public void deserializeAs_RemodelingInformation(ICustomDataInput param1) {
         * _loc4_ = 0;
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
         this.deserializeAsyncAs_RemodelingInformation(param1);
    }

    public void deserializeAsyncAs_RemodelingInformation(FuncTree param1) {
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
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element of RemodelingInformation.cosmeticId.");
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