package package com.ankamagames.dofus.network.messages.game.shortcut;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.shortcut.Shortcut;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class ShortcutBarRefreshMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6229;
    private boolean _isInitialized = false;
    private int barType = 0;
    private Shortcut shortcut = ;
    private FuncTree _shortcuttree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6229;
    }

    public ShortcutBarRefreshMessage initShortcutBarRefreshMessage(int param1,Shortcut  param2) {
         this.barType = param1;
         this.shortcut = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.barType = 0;
         this.shortcut = new Shortcut();
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
         this.serializeAs_ShortcutBarRefreshMessage(param1);
    }

    public void serializeAs_ShortcutBarRefreshMessage(ICustomDataOutput param1) {
         param1.writeByte(this.barType);
         param1.writeShort(this.shortcut.getTypeId());
         this.shortcut.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutBarRefreshMessage(param1);
    }

    public void deserializeAs_ShortcutBarRefreshMessage(ICustomDataInput param1) {
         this._barTypeFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.shortcut = ProtocolTypeManager.getInstance(Shortcut,_loc2_);
         this.shortcut.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutBarRefreshMessage(param1);
    }

    public void deserializeAsyncAs_ShortcutBarRefreshMessage(FuncTree param1) {
         param1.addChild(this._barTypeFunc);
         this._shortcuttree = param1.addChild(this._shortcuttreeFunc);
    }

    private void _barTypeFunc(ICustomDataInput param1) {
         this.barType = param1.readByte();
         if(this.barType < 0)
            throw new Exception("Forbidden value (" + this.barType + ") on element of ShortcutBarRefreshMessage.barType.");
    }

    private void _shortcuttreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.shortcut = ProtocolTypeManager.getInstance(Shortcut,_loc2_);
         this.shortcut.deserializeAsync(this._shortcuttree);
    }

}