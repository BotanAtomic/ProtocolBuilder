package package com.ankamagames.dofus.network.types.game.shortcut;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ShortcutObjectItem extends ShortcutObject implements INetworkType {

    private int protocolId = 371;
    private int itemUID = 0;
    private int itemGID = 0;


    public int getTypeId() {
         return 371;
    }

    public ShortcutObjectItem initShortcutObjectItem(int param1,int  param2,int  param3) {
         super.initShortcutObject(param1);
         this.itemUID = param2;
         this.itemGID = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.itemUID = 0;
         this.itemGID = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ShortcutObjectItem(param1);
    }

    public void serializeAs_ShortcutObjectItem(ICustomDataOutput param1) {
         super.serializeAs_ShortcutObject(param1);
         param1.writeInt(this.itemUID);
         param1.writeInt(this.itemGID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutObjectItem(param1);
    }

    public void deserializeAs_ShortcutObjectItem(ICustomDataInput param1) {
         super.deserialize(param1);
         this._itemUIDFunc(param1);
         this._itemGIDFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutObjectItem(param1);
    }

    public void deserializeAsyncAs_ShortcutObjectItem(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._itemUIDFunc);
         param1.addChild(this._itemGIDFunc);
    }

    private void _itemUIDFunc(ICustomDataInput param1) {
         this.itemUID = param1.readInt();
    }

    private void _itemGIDFunc(ICustomDataInput param1) {
         this.itemGID = param1.readInt();
    }

}