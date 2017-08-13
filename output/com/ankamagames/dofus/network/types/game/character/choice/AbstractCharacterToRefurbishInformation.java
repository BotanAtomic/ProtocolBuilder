package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.dofus.network.types.game.character.AbstractCharacterInformation;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AbstractCharacterToRefurbishInformation extends AbstractCharacterInformation implements INetworkType {

    private int protocolId = 475;
    private Vector<int> colors;
    private int cosmeticId = 0;
    private FuncTree _colorstree;


    public int getTypeId() {
         return 475;
    }

    public AbstractCharacterToRefurbishInformation initAbstractCharacterToRefurbishInformation(Number param1,Vector<int>  param2,int  param3) {
         super.initAbstractCharacterInformation(param1);
         this.colors = param2;
         this.cosmeticId = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.colors = new Vector.<int>();
         this.cosmeticId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AbstractCharacterToRefurbishInformation(param1);
    }

    public void serializeAs_AbstractCharacterToRefurbishInformation(ICustomDataOutput param1) {
         super.serializeAs_AbstractCharacterInformation(param1);
         param1.writeShort(this.colors.length);
         int _loc2_ = 0;
         while(_loc2_ < this.colors.length)
         {
            param1.writeInt(this.colors[_loc2_]);
            _loc2_++;
         }
         if(this.cosmeticId < 0)
         {
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element cosmeticId.");
         }
         param1.writeVarInt(this.cosmeticId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractCharacterToRefurbishInformation(param1);
    }

    public void deserializeAs_AbstractCharacterToRefurbishInformation(ICustomDataInput param1) {
         * _loc4_ = 0;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            this.colors.push(_loc4_);
            _loc3_++;
         }
         this._cosmeticIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractCharacterToRefurbishInformation(param1);
    }

    public void deserializeAsyncAs_AbstractCharacterToRefurbishInformation(FuncTree param1) {
         super.deserializeAsync(param1);
         this._colorstree = param1.addChild(this._colorstreeFunc);
         param1.addChild(this._cosmeticIdFunc);
    }

    private void _colorstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._colorstree.addChild(this._colorsFunc);
            _loc3_++;
         }
    }

    private void _colorsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.colors.push(_loc2_);
    }

    private void _cosmeticIdFunc(ICustomDataInput param1) {
         this.cosmeticId = param1.readVarUhInt();
         if(this.cosmeticId < 0)
         {
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element of AbstractCharacterToRefurbishInformation.cosmeticId.");
         }
    }

}