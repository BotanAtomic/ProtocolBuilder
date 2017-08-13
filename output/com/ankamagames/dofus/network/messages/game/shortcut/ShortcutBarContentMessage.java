package com.ankamagames.dofus.network.messages.game.shortcut;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.shortcut.Shortcut;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class ShortcutBarContentMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6231;
    private boolean _isInitialized = false;
    private int barType = 0;
    private Vector<Shortcut> shortcuts;
    private FuncTree _shortcutstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6231;
    }

    public ShortcutBarContentMessage initShortcutBarContentMessage(int param1,Vector<Shortcut>  param2) {
         this.barType = param1;
         this.shortcuts = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.barType = 0;
         this.shortcuts = new Vector.<Shortcut>();
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
         this.serializeAs_ShortcutBarContentMessage(param1);
    }

    public void serializeAs_ShortcutBarContentMessage(ICustomDataOutput param1) {
         param1.writeByte(this.barType);
         param1.writeShort(this.shortcuts.length);
         int _loc2_ = 0;
         while(_loc2_ < this.shortcuts.length)
         {
            param1.writeShort((this.shortcuts[_loc2_] as Shortcut).getTypeId());
            (this.shortcuts[_loc2_] as Shortcut).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutBarContentMessage(param1);
    }

    public void deserializeAs_ShortcutBarContentMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         Shortcut _loc5_ = null;
         this._barTypeFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(Shortcut,_loc4_);
            _loc5_.deserialize(param1);
            this.shortcuts.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutBarContentMessage(param1);
    }

    public void deserializeAsyncAs_ShortcutBarContentMessage(FuncTree param1) {
         param1.addChild(this._barTypeFunc);
         this._shortcutstree = param1.addChild(this._shortcutstreeFunc);
    }

    private void _barTypeFunc(ICustomDataInput param1) {
         this.barType = param1.readByte();
         if(this.barType < 0)
         {
            throw new Exception("Forbidden value (" + this.barType + ") on element of ShortcutBarContentMessage.barType.");
         }
    }

    private void _shortcutstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._shortcutstree.addChild(this._shortcutsFunc);
            _loc3_++;
         }
    }

    private void _shortcutsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         Shortcut _loc3_ = ProtocolTypeManager.getInstance(Shortcut,_loc2_);
         _loc3_.deserialize(param1);
         this.shortcuts.push(_loc3_);
    }

}