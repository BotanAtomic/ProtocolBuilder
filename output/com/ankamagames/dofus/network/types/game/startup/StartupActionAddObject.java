package com.ankamagames.dofus.network.types.game.startup;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemInformationWithQuantity;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class StartupActionAddObject extends Object implements INetworkType {

    private int protocolId = 52;
    private int uid = 0;
    private String title = "";
    private String text = "";
    private String descUrl = "";
    private String pictureUrl = "";
    private Vector<ObjectItemInformationWithQuantity> items;
    private FuncTree _itemstree;


    public int getTypeId() {
         return 52;
    }

    public StartupActionAddObject initStartupActionAddObject(int param1,String  param2,String  param3,String  param4,String  param5,Vector<ObjectItemInformationWithQuantity>  param6) {
         this.uid = param1;
         this.title = param2;
         this.text = param3;
         this.descUrl = param4;
         this.pictureUrl = param5;
         this.items = param6;
         return this;
    }

    public void reset() {
         this.uid = 0;
         this.title = "";
         this.text = "";
         this.descUrl = "";
         this.pictureUrl = "";
         this.items = new Vector.<ObjectItemInformationWithQuantity>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_StartupActionAddObject(param1);
    }

    public void serializeAs_StartupActionAddObject(ICustomDataOutput param1) {
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
         }
         param1.writeInt(this.uid);
         param1.writeUTF(this.title);
         param1.writeUTF(this.text);
         param1.writeUTF(this.descUrl);
         param1.writeUTF(this.pictureUrl);
         param1.writeShort(this.items.length);
         int _loc2_ = 0;
         while(_loc2_ < this.items.length)
         {
            (this.items[_loc2_] as ObjectItemInformationWithQuantity).serializeAs_ObjectItemInformationWithQuantity(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StartupActionAddObject(param1);
    }

    public void deserializeAs_StartupActionAddObject(ICustomDataInput param1) {
         ObjectItemInformationWithQuantity _loc4_ = null;
         this._uidFunc(param1);
         this._titleFunc(param1);
         this._textFunc(param1);
         this._descUrlFunc(param1);
         this._pictureUrlFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItemInformationWithQuantity();
            _loc4_.deserialize(param1);
            this.items.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StartupActionAddObject(param1);
    }

    public void deserializeAsyncAs_StartupActionAddObject(FuncTree param1) {
         param1.addChild(this._uidFunc);
         param1.addChild(this._titleFunc);
         param1.addChild(this._textFunc);
         param1.addChild(this._descUrlFunc);
         param1.addChild(this._pictureUrlFunc);
         this._itemstree = param1.addChild(this._itemstreeFunc);
    }

    private void _uidFunc(ICustomDataInput param1) {
         this.uid = param1.readInt();
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element of StartupActionAddObject.uid.");
         }
    }

    private void _titleFunc(ICustomDataInput param1) {
         this.title = param1.readUTF();
    }

    private void _textFunc(ICustomDataInput param1) {
         this.text = param1.readUTF();
    }

    private void _descUrlFunc(ICustomDataInput param1) {
         this.descUrl = param1.readUTF();
    }

    private void _pictureUrlFunc(ICustomDataInput param1) {
         this.pictureUrl = param1.readUTF();
    }

    private void _itemstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._itemstree.addChild(this._itemsFunc);
            _loc3_++;
         }
    }

    private void _itemsFunc(ICustomDataInput param1) {
         ObjectItemInformationWithQuantity _loc2_ = new ObjectItemInformationWithQuantity();
         _loc2_.deserialize(param1);
         this.items.push(_loc2_);
    }

}