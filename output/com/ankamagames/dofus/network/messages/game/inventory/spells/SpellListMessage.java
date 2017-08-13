package package com.ankamagames.dofus.network.messages.game.inventory.spells;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.SpellItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SpellListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1200;
    private boolean _isInitialized = false;
    private boolean spellPrevisualization = false;
    private Vector.<SpellItem> spells = ;
    private FuncTree _spellstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1200;
    }

    public SpellListMessage initSpellListMessage(boolean param1,Vector.<SpellItem>  param2) {
         this.spellPrevisualization = param1;
         this.spells = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.spellPrevisualization = false;
         this.spells = new Vector.<SpellItem>();
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
         this.serializeAs_SpellListMessage(param1);
    }

    public void serializeAs_SpellListMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.spellPrevisualization);
         param1.writeShort(this.spells.length);
         int _loc2_ = 0;
         while(_loc2_ < this.spells.length)
            (this.spells[_loc2_] as SpellItem).serializeAs_SpellItem(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SpellListMessage(param1);
    }

    public void deserializeAs_SpellListMessage(ICustomDataInput param1) {
         SpellItem _loc4_ = null;
         this._spellPrevisualizationFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new SpellItem();
            _loc4_.deserialize(param1);
            this.spells.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SpellListMessage(param1);
    }

    public void deserializeAsyncAs_SpellListMessage(FuncTree param1) {
         param1.addChild(this._spellPrevisualizationFunc);
         this._spellstree = param1.addChild(this._spellstreeFunc);
    }

    private void _spellPrevisualizationFunc(ICustomDataInput param1) {
         this.spellPrevisualization = param1.readBoolean();
    }

    private void _spellstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._spellstree.addChild(this._spellsFunc);
            _loc3_++;
    }

    private void _spellsFunc(ICustomDataInput param1) {
         SpellItem _loc2_ = new SpellItem();
         _loc2_.deserialize(param1);
         this.spells.push(_loc2_);
    }

}